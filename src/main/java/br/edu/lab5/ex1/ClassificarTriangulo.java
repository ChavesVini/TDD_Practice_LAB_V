package br.edu.lab5.ex1;

public class ClassificarTriangulo {
    public String classificarTriangulo(Triangulo triangulo) {
        Double ladoBase = triangulo.getBase();  
        Double ladoDireito = triangulo.getLadoDireito(); 
        Double ladoEsquerdo = triangulo.getLadoEsquerdo();   
        
        if ((ladoBase <= 0 || ladoDireito <= 0 || ladoEsquerdo <= 0) ||
            (ladoBase + ladoDireito <= ladoEsquerdo) ||
            (ladoBase + ladoEsquerdo <= ladoDireito) ||
            (ladoDireito + ladoEsquerdo <= ladoBase)) {
            return "Triângulo inválido";
        } else if ((ladoBase.equals(ladoDireito)) && (ladoEsquerdo.equals(ladoDireito)) && (ladoBase.equals(ladoEsquerdo))) {
            return "Equilátero";
        } else if ((!ladoBase.equals(ladoDireito)) && (!ladoEsquerdo.equals(ladoDireito)) && (!ladoBase.equals(ladoEsquerdo))) {
            return "Escaleno";
        } else {
            return "Isósceles";
        }
    }
}

