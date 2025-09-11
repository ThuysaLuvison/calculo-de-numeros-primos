class PrimosThread3 extends Thread {
    private int inicio, fim;

    public PrimosThread3(int inicio, int fim) {
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
        System.out.print("[" + inicio + "-" + fim + "] Primos: ");
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class PrimosVersao3 {
    public static void main(String[] args) {
        int inicio = 5, fim = 25;
        int meio = (inicio + fim) / 2;

        Thread t1 = new PrimosThread3(inicio, meio);
        Thread t2 = new PrimosThread3(meio + 1, fim);

        t1.start();
        t2.start();
    }
}