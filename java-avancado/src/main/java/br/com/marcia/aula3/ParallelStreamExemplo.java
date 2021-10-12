package br.com.marcia.aula3;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.*;

public class ParallelStreamExemplo {

    public static void main(String[] args) {

        // Serial
        long inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).forEach(num -> fatorial(num));
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Serial :: " + (fim - inicio));

        // Parallel
        inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).parallel().forEach(num -> fatorial(num));
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Parallel :: " + (fim - inicio));

        /**
         Tempo de execução Serial :: 15313
         Tempo de execução Parallel :: 3177
         */

        // Pode chamar stream().parallel() OU parallelStream() direto
        List<String> nomes = asList("João", "Paulo", "Oliveira", "Santos");
        nomes.stream().parallel().forEach(System.out::println);
        System.out.println();
        nomes.parallelStream().forEach(System.out::println);

        /**
         Oliveira
         Santos
         João
         Paulo

         Oliveira
         Paulo
         João
         Santos
         */
    }

    public static long fatorial(long num){
        long fat = 1;

        for (long i = 2; i <= num ; i++) {
            fat *= i;
        }
        return fat;
    }
}
