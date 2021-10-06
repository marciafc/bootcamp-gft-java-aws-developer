package br.com.marcia.aula1;

import java.util.function.UnaryOperator;

public class Funcional {

    public static void main(String[] args) {

        UnaryOperator<Integer> calcularValorVezes3 = valor -> valor * 3;

        System.out.println("O resutado é :: "+calcularValorVezes3.apply(10));
        //O resutado é :: 30
    }
}
