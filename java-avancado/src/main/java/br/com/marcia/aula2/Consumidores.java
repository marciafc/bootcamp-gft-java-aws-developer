package br.com.marcia.aula2;

import java.util.function.Consumer;

public class Consumidores {

    public static void main(String[] args) {

        Consumer<String> imprimirUmaFrase2 = frase -> System.out.println(frase);
        imprimirUmaFrase2.accept("Oiii");
        // Oiii


        // Method Reference: apenas utilizar o parâmetro da forma que ele foi recebido
        Consumer<String> imprimirUmaFrase = System.out::println;
        imprimirUmaFrase.accept("Hello World");
        // Hello World
    }
}
