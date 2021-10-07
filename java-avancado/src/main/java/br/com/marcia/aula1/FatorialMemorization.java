package br.com.marcia.aula1;

import java.util.HashMap;
import java.util.Map;

class FatorialMemorization {

    static Map<Integer,Integer> MAPA_FATORIAL = new HashMap<>();

    public static void main(String[] args) {

        long tempoInicial = System.nanoTime();
        System.out.println(fatorialComMemorization(15));
        long tempoFinal = System.nanoTime();
        System.out.println("FATORIAL de 15 " + (tempoFinal - tempoInicial));

        // fatorial de 15 já está em cache
        tempoInicial = System.nanoTime();
        System.out.println(fatorialComMemorization(15));
        tempoFinal = System.nanoTime();
        System.out.println("FATORIAL de 15 " + (tempoFinal - tempoInicial));

        // fatorial de 15 já está em cache, falta só o 16
        tempoInicial = System.nanoTime();
        System.out.println(fatorialComMemorization(16));
        tempoFinal = System.nanoTime();
        System.out.println("FATORIAL de 16 " + (tempoFinal - tempoInicial));

        // fatorial de 14 já está em cache pois já calculou até o fatorial de 16
        tempoInicial = System.nanoTime();
        System.out.println(fatorialComMemorization(14));
        tempoFinal = System.nanoTime();
        System.out.println("FATORIAL de 14 " + (tempoFinal - tempoInicial));

    }

    public static Integer fatorialComMemorization(Integer value ) {
        if ( value == 1 ) {
            return value;
        } else {
            if (MAPA_FATORIAL.containsKey(value)) {
                return MAPA_FATORIAL.get(value);
            }  else {
                Integer resultado =  value * fatorialComMemorization(value -1);
                MAPA_FATORIAL.put(value, resultado);
                return resultado;
            }
        }
    }
}



