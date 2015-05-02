import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Arrays;

class InfiniteHouseOfPancakes {
    static TokenInput in = IO.tokenInput();
    static PrintWriter out = IO.output();

    void solve() throws Exception {
        int[] a = new int[1001];
        for (int i = 0, d = in.readInt(); i < d; i++) {
            a[in.readInt()]++;
        }
        out.println(findMin(a, a.length - 1));
    }

    int findMin(int[] a, int m) {
        while (m > 0 && a[m] == 0) m--;
        if (m < 1) {
            return 100000;
        }
        int min = m;
        for (int i = a[m]; i <= m / 2; i++) {
            int[] b = Arrays.copyOf(a, m);
            b[i] += a[m];
            b[m - i] += a[m];
            min = Math.min(min, findMin(b, m - 1) + a[m]);
        }
        return min;
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
    static TokenInput tokenInput() {
        return new TokenInput(lineInput());
    }
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