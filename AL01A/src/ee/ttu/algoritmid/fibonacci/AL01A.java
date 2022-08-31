package ee.ttu.algoritmid.fibonacci;

public class AL01A {
    /**
     * Compute the Fibonacci sequence number.
     * @param n The number of the sequence to compute.
     * @return The n-th number in Fibonacci series.
     */
    public static String iterativeF(int n) {
        if(n <= 1) {
            return Integer.toString(n);
        }
        int a = 1, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return Integer.toString(a);
    }

    public static void main(String[] args) {
        System.out.println(iterativeF(0));
    }
}
