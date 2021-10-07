package br.com.marcia.aula2;

public class FuncaoAltaOrdem {

    public static void main(String[] args) {

        // Definindo comportamento -> paradigma funcional
        Calculo soma =  ( a, b ) -> a + b;

        // Chama para ser executado -> paradigma funcional
        System.out.println(executarOperacao(soma,1,3));
        System.out.println(executarOperacao( ( a, b ) -> a + b,1,3));

        // paradigma imperativo
        System.out.println(somar(1, 3));
        // 4

        System.out.println("Demais operações matemáticas...");
        Calculo subtracao =  ( a, b ) -> a - b;
        Calculo multiplicacao =  ( a, b ) -> a * b;
        Calculo divisao =  ( a, b ) -> a / b;
        System.out.println(executarOperacao(subtracao,10,3));
        System.out.println(executarOperacao(multiplicacao,10,3));
        System.out.println(executarOperacao(divisao,12,3));

        System.out.println("Demais operações matemáticas chamando direto...");
        System.out.println(executarOperacao( ( a, b ) -> a - b,10,3));
        System.out.println(executarOperacao( ( a, b ) -> a * b,10,3));
        System.out.println(executarOperacao( ( a, b ) -> a / b,12,3));

    }

    public static int executarOperacao(Calculo calculo, int a, int b){

        // System.out.println(calculo.getClass()); // class br.com.marcia.aula2.FuncaoAltaOrdem$$Lambda$14/0x0000000800066840

        return calculo.calcular(a,b);
    }

    public static int somar(int a, int b) {
        return a + b;
    }
}


@FunctionalInterface
interface Calculo {
    int calcular(int a, int b);
}