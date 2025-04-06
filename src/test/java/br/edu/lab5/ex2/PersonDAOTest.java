package br.edu.lab5.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PersonDAOTest {
    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    public void validarPessoa(Integer idPerson, String namePerson, Integer agePerson, List<Email> nameEmail, List<String> errosEsperados) {
        Person person = new Person(idPerson, namePerson, agePerson, nameEmail);
        PersonDAO dao = new PersonDAO();
        List<String> errorsList = dao.isValidToInclude(person);
        Assertions.assertEquals(errosEsperados, errorsList);
        errorsList.clear();
    }
    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(
                Arguments.of(1, "Joao1", 25, Arrays.asList(new Email(1, "joao@email.com")), List.of("Nome incorreto")),
                Arguments.of(2, "Maria", 250, Arrays.asList(new Email(2, "maria@email.com")), List.of("Nome incorreto", "Idade incorreta")),
                Arguments.of(3, "Pedro Silva", 30, Arrays.asList(new Email(3, "pedro@dominio")), List.of("E-mail incorreto")),
                Arguments.of(4, "Lucas Oliveira", 0, Arrays.asList(new Email(4, "lucas@email.com")), List.of("Idade incorreta")),
                Arguments.of(5, "Ana Clara", 20, new ArrayList<>(), List.of("Precisa ter um e-mail")),
                Arguments.of(6, "Carlos Souza", 32, Arrays.asList(new Email(5,"carlos@email.com")), new ArrayList<>())
        );
    }
}
