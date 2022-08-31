package ee.ttu.algoritmid.fibonacci;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class AL01B {

    /**
     * Estimate or find the exact time required to compute the n-th Fibonacci number.
     * @param n The n-th number  to compute.
     * @return The time estimate or exact time in YEARS.
     */
    public static String timeToComputeRecursiveFibonacci(int n) {
        double start = System.currentTimeMillis();
        recursiveF(n);
        double end = System.currentTimeMillis();

        double duration = end - start;

        double durationInYears = duration / 307584 / 100000;

        return Double.toString(durationInYears);
    }

    /**
     * Compute the Fibonacci sequence number recursively.
     * (You need this in the timeToComputeRecursiveFibonacci(int n) function!)
     * @param n The n-th number to compute.
     * @return The n-th Fibonacci number as a string.
     */
    public static BigInteger recursiveF(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);
        return recursiveF(n - 1).add(recursiveF(n - 2));
    }

    public static void main(String[] args) {
        System.out.println(timeToComputeRecursiveFibonacci(33));
    }
}