import java.io.*;

public class Homework {
    public static void main(String[] args) throws Exception {
        TokenInput in = new TokenInput(new BufferedReader(new FileReader("input.txt")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

        int[] primes = new int[664579];
        primes[0] = 2;
        int primesCount = 1;

        main:
        for (int candidate = 3; candidate <= 10000000; candidate += 2) {
            for (int i = 0, limit = (int) Math.ceil(Math.sqrt(candidate)); i < primesCount; i++) {
                int prime = primes[i];
                if (prime > limit) {
                    break;
                }
                if (candidate % prime == 0) {
                    continue main;
                }
            }
            primes[primesCount++] = candidate;
        }

        byte[] counts = new byte[10000001];
        for (int i = 0; i < primesCount; i++) {
            int prime = primes[i];
            for (int j = prime; j < counts.length; j += prime) {
                counts[j]++;
            }
        }

        int[][] c = new int[9][counts.length];
        for (int i = 2; i < counts.length; i++) {
            for (int[] cc : c) {
                cc[i] = cc[i - 1];
            }
            c[counts[i]][i]++;
        }

        for (int t = 1, ts = in.readInt(); t <= ts; t++) {
            int a = in.readInt();
            int b = in.readInt();
            long k = in.readLong();

            int result;
            if (k < c.length) {
                int ki = (int) k;
                result = c[ki][b] - c[ki][a - 1];
            } else {
                result = 0;
            }

            out.print("Case #");
            out.print(t);
            out.print(": ");
            out.println(result);
        }

        out.flush();
    }
}

class TokenInput {
    private StreamTokenizer in;

    TokenInput(Reader reader) throws Exception {
        in = new StreamTokenizer(reader);
    }

    double readDouble() throws Exception {
        in.nextToken();
        return in.nval;
    }

    int readInt() throws Exception {
        return (int) readDouble();
    }

    long readLong() throws Exception {
        return (long) readDouble();
    }
}