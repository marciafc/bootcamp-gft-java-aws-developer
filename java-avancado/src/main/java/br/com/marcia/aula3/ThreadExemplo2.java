package br.com.marcia.aula3;

public class ThreadExemplo2 {

    public static void main(String[] args) {

        GeradorPDF2 iniciarGeradorPdf = new GeradorPDF2();
        BarraDeCarregamento2 iniciarBarraDeCarregamento = new BarraDeCarregamento2(iniciarGeradorPdf);

        iniciarGeradorPdf.run();
        iniciarBarraDeCarregamento.run();

    }

}

class GeradorPDF2 implements Runnable {

    public void run() {
        try {
            System.out.println("Iniciar geração de PDF");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}


class BarraDeCarregamento2 implements Runnable {

    private Runnable iniciarGeradorPdf;

    public BarraDeCarregamento2(Runnable iniciarGeradorPdf) {
        this.iniciarGeradorPdf = iniciarGeradorPdf;
    }

    public void run() {
        while (true){
            try {
                Thread.sleep(500);

                // Runnable nao tem acesso ao isAlive
                /*if (!iniciarGeradorPdf.isAlive()){
                    break;
                }*/
                System.out.println("Loading ... ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

