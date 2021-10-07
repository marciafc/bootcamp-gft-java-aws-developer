package br.com.marcia.aula1.FatorialRecursivo;

public class FatorialTailCall {

    public static void main(String[] args) {
        //System.out.println(fatorialA(100000));  // Exception in thread "main" java.lang.StackOverflowError
        //System.out.println(fatorialA(1000));    // Infinity
       System.out.println(fatorialA(5));    // 120.0
    }

    public static double fatorialA( double valor ) {
        return fatorialComTailCall(valor,1);
    }

    public static double fatorialComTailCall(double valor, double numero){
        if (valor == 0){
            return numero;
        }
        return fatorialComTailCall(valor-1,numero*valor);
    }

    /**
     5   * 4
     20  * 3
     60  * 2
     120 * 1
     120
     */

}
