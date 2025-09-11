public class PrimosVersao1 {

    public static boolean ehPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int inicio = 5;
        int fim = 25;

        System.out.println("Intervalo: " + inicio + " a " + fim);
        System.out.print("Primos existentes: ");

        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                System.out.print(i + " ");
            }
        }
    }
}