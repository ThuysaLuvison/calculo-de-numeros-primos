import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PrimosThread5 extends Thread {
    private int inicio, fim;
    private List<Integer> listaCompartilhada;

    public PrimosThread5(int inicio, int fim, List<Integer> listaCompartilhada) {
        this.inicio = inicio;
        this.fim = fim;
        this.listaCompartilhada = listaCompartilhada;
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
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                synchronized (listaCompartilhada) { // garante que várias threads não quebrem a lista
                    listaCompartilhada.add(i);
                }
            }
        }
    }
}

public class PrimosVersao5 {
    public static void main(String[] args) {
        List<Integer> primos = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new PrimosThread5(5, 50, primos);
        Thread t2 = new PrimosThread5(51, 100, primos);
        Thread t3 = new PrimosThread5(101, 150, primos);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ordena e imprime
        Collections.sort(primos);
        System.out.println("Números primos encontrados:");
        for (int i = 0; i < primos.size(); i++) {
            System.out.println((i + 1) + " -> " + primos.get(i));
        }
    }
}
