class PrimosThread extends Thread {
    private int inicio, fim;

    public PrimosThread(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    private boolean ehPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println("Intervalo: " + inicio + " a " + fim);
        System.out.print("Primos existentes: ");
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class PrimosVersao2 {
    public static void main(String[] args) {
        Thread t = new PrimosThread(5, 25);
        t.start();
    }
}