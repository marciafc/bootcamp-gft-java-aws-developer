package br.com.marcia.aula2;

import java.util.function.Predicate;

public class Predicados {

    public static void main(String[] args) {

        Predicate<String> estaVazio = String::isEmpty;

        System.out.println(estaVazio.test(""));      // true
        System.out.println(estaVazio.test("Joao"));  // false


        Predicate<String> estaVazio2 = valor -> valor.isEmpty();
        System.out.println(estaVazio2.test(""));    // true
    }
}
