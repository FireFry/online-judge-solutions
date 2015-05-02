import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.math.BigInteger;

class InfiniteHouseOfPancakes {
    static TokenInput in = IO.tokenInput();
    static PrintWriter out = IO.output();

    private static final long[] TENS = {
            1L,
            10L,
            100L,
            1000L,
            10000L,
            100000L,
            1000000L,
            10000000L,
            100000000L,
            1000000000L,
            10000000000L,
            100000000000L,
            1000000000000L,
            10000000000000L,
            100000000000000L,
            1000000000000000L,
    };

    void solve() throws Exception {
        long n = in.readLong();
        System.out.println(n);
        long s = -1;
        int ten = 0;
        while (TENS[ten + 1] < n) {
           ten++;
        }
        while (n > 0) {
            if (n % 10 == 0) {
                n--;
                s++;
            }
            long reverse = reverse(n / (TENS[(ten + 2) / 2]));
            if (reverse > 1) {
                s += reverse;
            }
            s += n % (TENS[(ten + 2) / 2]);
            s += 1;
            n = TENS[ten--] - 1;
        }
        out.println(s);
    }

    private long reverse(long x) {
        long reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        for (int t = 1, ts = IO.readInt(InfiniteHouseOfPancakes.in); t <= ts; t++) {
            InfiniteHouseOfPancakes.out.print("Case #");
            InfiniteHouseOfPancakes.out.print(t);
            InfiniteHouseOfPancakes.out.print(": ");
            new InfiniteHouseOfPancakes().solve();
        }
        InfiniteHouseOfPancakes.out.flush();
    }
}

class IO {
    static PrintWriter output() { try { return new PrintWriter(new BufferedWriter(new FileWriter("output.txt"))); } catch (IOException e) { throw new RuntimeException(e); }}
    static BufferedReader lineInput() { try { return new BufferedReader(new FileReader("input.txt")); } catch (IOException e) { throw new RuntimeException(e); }}
    static TokenInput tokenInput() { return new TokenInput(lineInput()); }
    static int readInt(TokenInput in) throws Exception { return in.readInt(); }
    static int readInt(BufferedReader in) throws Exception { return Integer.parseInt(in.readLine()); }
}

class TokenInput {
    StreamTokenizer in;
    TokenInput(Reader reader) { in = new StreamTokenizer(reader); }
    double readDouble() throws Exception { in.nextToken(); return in.nval; }
    int readInt() throws Exception { return (int) readDouble(); }
    long readLong() throws Exception { return (long) readDouble(); }
}
