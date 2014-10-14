import java.io.*;
import java.math.BigInteger;

public class Solution {
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        int[] primes = findPrimes();
        int[] counts = new int[primes.length];
        for (int i = 0; i < 10; i++) {
            int x = readInt();
            int j = 0;
            while (x != 1) {
                int primesj;
                while (x % (primesj = primes[j]) > 0) {
                    j++;
                }
                while (x % primesj == 0) {
                    x /= primesj;
                    counts[j]++;
                }
            }
        }
        int result = 1;
        for (int i = 0; i < primes.length; i++) {
            int counti = counts[i];
            if (counti > 0) {
                result = (result * (counti + 1)) % 10;
            }
        }
        out.println(result);
        out.flush();
    }

    private static int[] findPrimes() {
        int[] primes = new int[1229];
        int primesSize = 0;
        for (int x = 2; x <= 10000; x++) {
            int ai;
            boolean isPrime = true;
            int i = 0;
            while (i < primesSize && (isPrime = x % (ai = primes[i]) > 0) && ai * ai < x) {
                i++;
            }
            if (isPrime) {
                primes[primesSize++] = x;
            }
        }
        return primes;
    }

    private static int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}
