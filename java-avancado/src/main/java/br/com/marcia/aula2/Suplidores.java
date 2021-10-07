package br.com.marcia.aula2;

import java.util.function.Supplier;

public class Suplidores {

    public static void main(String[] args) {

        Supplier<Pessoa> instanciaPessoa = () -> new Pessoa();
        System.out.println(instanciaPessoa.get());
        // nome : joao, idade: 23

        Supplier<Pessoa> instanciaPessoa2 = Pessoa::new;
        System.out.println(instanciaPessoa2.get());
        // nome : joao, idade: 23
    }
}



class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
        nome = "joao";
        idade = 23;
    }

    @Override
    public String toString() {
        return String.format("nome : %s, idade: %d", nome, idade) ;
    }
}
