class PrimosThread4 extends Thread {
    private int inicio, fim;

    public PrimosThread4(int inicio, int fim) {
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
        System.out.print("Thread [" + inicio + "-" + fim + "] -> ");
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class PrimosVersao4 {
    public static void main(String[] args) {
        Thread t1 = new PrimosThread4(5, 50);
        Thread t2 = new PrimosThread4(51, 100);
        Thread t3 = new PrimosThread4(101, 150);

        t1.start();
        t2.start();
        t3.start();
    }
}