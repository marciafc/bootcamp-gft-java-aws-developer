package br.com.marcia.aula1;

public class Aula {
    public static void main(String[] args) {

        Funcao1 funcao1 = valor -> {
            return valor;
        };

        System.out.println(funcao1.gerar("Joao"));
        //Joao

        System.out.println(funcao1.metodoDefault());
    }
}


@FunctionalInterface
interface Funcao1 {

    String gerar(String valor);

    //String gerar2(String valor); // não é permitido

    default String metodoDefault() {
        return "método default";
    }
}
