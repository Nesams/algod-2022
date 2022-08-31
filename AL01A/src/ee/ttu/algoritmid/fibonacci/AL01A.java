package ee.ttu.algoritmid.fibonacci;

import java.math.BigInteger;

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
        BigInteger a = BigInteger.ONE, b = BigInteger.ONE, c;
        for (int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return a.toString();
    }

    public static void main(String[] args) {
        System.out.println(iterativeF(0));
    }
}
