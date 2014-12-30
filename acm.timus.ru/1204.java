import java.io.*;
import java.util.Arrays;

public class Solution {
    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    int[] primes = new int[3401];

    void solve() throws IOException {
        findPrimes();
        for (int k = (int) readNumber(); k > 0; k--) {
            long n = (long) readNumber();
            int pi = 0;
            while (n % primes[pi] > 0) {
                pi++;
            }
            long p = primes[pi];
            long q = n / p;

            Tuple t = f(q, p);
            long[] result = new long[]{0, 1, q * (t._1 > 0 ? t._1 : t._1 + p), p * (t._2 > 0 ? t._2 : t._2 + q)};

            Arrays.sort(result);
            out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
        }
        out.flush();
    }

    Tuple f(long q, long p) {
        if (p == 0) {
            return new Tuple(1L, 0L);
        }
        Tuple result = f(p, q % p);
        return new Tuple(result._2, result._1 - (q / p) * result._2);
    }

    void findPrimes() {
        primes[0] = 2;
        primes[1] = 3;
        int size = 2;

        int candidate = 5;
        while (size < primes.length) {
            boolean isPrime = true;
            for (int i = 0; isPrime && i < size; i++) {
                isPrime = candidate % primes[i] != 0;
            }
            if (isPrime) {
                primes[size++] = candidate;
            }
            candidate += 2;
        }
    }

    double readNumber() throws IOException {
        in.nextToken();
        return in.nval;
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    class Tuple {
        long _1;
        long _2;

        Tuple(long _1, long _2) {
            this._1 = _1;
            this._2 = _2;
        }
    }
}
