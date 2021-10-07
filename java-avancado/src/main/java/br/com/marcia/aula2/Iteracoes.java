package br.com.marcia.aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

    public static void main(String[] args) {

        String[] nomes = {"Joao","Joao", "Paulo","Oliveira","Santos","Instrutor","Java"};
        Integer[] numeros = {1, 2, 3, 4, 5};

        imprimirNomesFiltrados(nomes);
        imprimirTodosNomes(nomes);
        imprimirODobroDeCadaItemDaLista(numeros);

        // Stream a partir de uma List
        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor");
        profissoes.add("Testador");
        profissoes.add("Gerente de projeto");
        profissoes.add("Gerente de qualidade");

        profissoes.stream()
                .filter(profissao -> profissao.startsWith("Gerente"))
                .forEach(System.out::println);
    }


    public static void imprimirNomesFiltrados(String... nomes){

        String retorno = "";

        // Complexo!
        for (int i = 0; i < nomes.length ; i++) {
            if (nomes[i].equals("Joao")) {
              retorno += " " + nomes[i];
            }
        }
        System.out.println("Nomes do for: " + retorno);
        // Nomes do for:  Joao Joao


        // Muito mais simples!
        String nomesparaImprimirDaStream = Stream.of(nomes)
                .filter(nome -> nome.equals("Joao"))
                .collect(Collectors.joining(" ")); // String
        System.out.println("Nomes do stream: " + nomesparaImprimirDaStream);
        // Nomes do stream: Joao Joao

    }


    public static void imprimirTodosNomes(String... nomes){
        System.out.println();

        for (String nome : nomes) {
            System.out.println("Impresso pelo for: " + nome);
        }

        System.out.println();

        Stream.of(nomes)
                .forEach(nome -> System.out.println("Impresso pelo forEach: " + nome));

        System.out.println();

        // Usando Method Reference
        Stream.of(nomes)
                .forEach(System.out::println);
    }

    public static void imprimirODobroDeCadaItemDaLista(Integer... numeros) {

        System.out.println();

        for (Integer numero : numeros) {
            System.out.println(numero * 2);
        }

        System.out.println();

        Stream.of(numeros).map( numero -> numero * 2 )
                           .forEach(System.out::println);
    }
}
