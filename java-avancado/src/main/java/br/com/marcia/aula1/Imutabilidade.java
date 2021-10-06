package br.com.marcia.aula1;

import java.util.function.UnaryOperator;

public class Imutabilidade {
    public static void main(String[] args) {

        int valor = 20;

        UnaryOperator<Integer> retornarDobro = v -> v * 2;

        System.out.println(retornarDobro.apply(valor)); // retorna o dobro do valor
        System.out.println(valor); // valor nao sera alterado
        //40
        //20


        UnaryOperator<Integer> outroValor = v -> {
            // valor = 100; // Não é possível alterar por causa da imutabilidade
            return v * 2;
        };
    }
}
