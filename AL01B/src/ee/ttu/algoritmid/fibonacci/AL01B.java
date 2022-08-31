package ee.ttu.algoritmid.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class AL01B {

    /**
     * Estimate or find the exact time required to compute the n-th Fibonacci number.
     * @param n The n-th number  to compute.
     * @return The time estimate or exact time in YEARS.
     */
    public static String timeToComputeRecursiveFibonacci(int n) {
        long start = System.nanoTime();
        recursiveF(5);
        long end = System.nanoTime();

        BigDecimal duration = BigDecimal.valueOf((end - start));

        BigDecimal lines = iterativeF(n).multiply(BigDecimal.valueOf(3)).subtract(BigDecimal.valueOf(2));

        BigDecimal finalNanoSeconds = duration.multiply(lines).divide(iterativeF(5), 10, RoundingMode.HALF_EVEN);

        BigDecimal durationInSeconds = finalNanoSeconds.divide(BigDecimal.valueOf(1000000000),10, RoundingMode.HALF_EVEN);
        BigDecimal durationInMonths = durationInSeconds.divide(BigDecimal.valueOf(26282888), 10, RoundingMode.HALF_EVEN);
        BigDecimal durationInYears = durationInMonths.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_EVEN);

        return durationInYears.toString();
    }

    public static BigDecimal iterativeF(int n) {
        if(n <= 1) {
            return BigDecimal.valueOf(n);
        }
        BigDecimal a = BigDecimal.ONE, b = BigDecimal.ONE, c;
        for (int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return a;
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
        System.out.println(timeToComputeRecursiveFibonacci(12));
    }
}