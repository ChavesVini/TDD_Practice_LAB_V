package br.edu.lab5.ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ClassificarTrianguloTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    public void validarCalculoTriangulo(Double ladoBase, Double ladoEsquerdo, Double ladoDireito, String classificacaoTrianguloEsperado) {
        Triangulo triangulo = new Triangulo(ladoBase, ladoEsquerdo, ladoDireito);
        ClassificarTriangulo clTriangulo = new ClassificarTriangulo();
        String classificacaoTriangulo = clTriangulo.classificarTriangulo(triangulo);
        Assertions.assertEquals(classificacaoTrianguloEsperado, classificacaoTriangulo);
    }

    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(
                Arguments.of(20.0, 20.0, 16.0, "Isósceles"),
                Arguments.of(45.0, 45.0, 30.62, "Isósceles"),
                Arguments.of(10.0, 0.0, 0.0, "Triângulo inválido"),
                Arguments.of(20.0, 20.0, 59.0, "Triângulo inválido"),
                Arguments.of(10.0, 5.0, 5.0, "Triângulo inválido"),

                Arguments.of(59.052, 59.052, 59.052, "Equilátero"),
                Arguments.of(12.4, 12.4, 12.4, "Equilátero"),
                Arguments.of(0.0, 0.0, 0.0, "Triângulo inválido"),
                Arguments.of(-1.0, -1.0, -1.0, "Triângulo inválido"),

                Arguments.of(8.5, 8.1, 2.0, "Escaleno"),
                Arguments.of(33.0, 62.0, 42.0, "Escaleno"),
                Arguments.of(53.0, 43.0, 0.0, "Triângulo inválido"),
                Arguments.of(-33.0, -62.0, -42.0, "Triângulo inválido"),
                Arguments.of(20.0, 10.0, 10.0, "Triângulo inválido")
        );
    }
}
