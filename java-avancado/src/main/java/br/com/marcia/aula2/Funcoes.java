package br.com.marcia.aula2;

import java.util.function.Function;

public class Funcoes {

    public static void main(String[] args) {

        Function<String, String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        System.out.println(retornarNomeAoContrario.apply("joao"));
        // oaoj

        Function<String, Integer> converterStringParaInteiroECalcularODobro = string -> Integer.valueOf(string) * 2;
        System.out.println(converterStringParaInteiroECalcularODobro.apply("20"));
        // 40

        // Function<String, Integer> converterStringParaInteiro = Integer::valueOf * 2; // não compila
        Function<String, Integer> converterStringParaInteiro = Integer::valueOf;
        System.out.println(converterStringParaInteiro.apply("20"));
        // 20
    }
}
