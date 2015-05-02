import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;

class NoisyNeighbors {
    static TokenInput in = IO.tokenInput();
    static PrintWriter out = IO.output();

    static int[] DI = {0, 1};
    static int[] DJ = {1, 0};

    int r, c, n;
    boolean[] b;
    int minCost = Integer.MAX_VALUE;

    void solve() throws Exception {
        r = in.readInt();
        c = in.readInt();
        n = in.readInt();
        b = new boolean[r * c];
        rec(0, n);
        out.println(minCost);
    }

    void rec(int offset, int remain) {
        if (offset == b.length) {
            assert remain == 0;
            investigate();
            return;
        }
        if (b.length - offset > remain) {
            b[offset] = false;
            rec(offset + 1, remain);
        }
        if (remain > 0) {
            b[offset] = true;
            rec(offset + 1, remain - 1);
        }
    }

    void investigate() {
        int cost = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (b[i + r * j]) {
                    for (int d = 0; d < DI.length; d++) {
                        int ni = i + DI[d];
                        int nj = j + DJ[d];
                        if (ni < r && nj < c && b[ni + r * nj]){
                            cost++;
                        }
                    }
                }
            }
        }
        if (cost < minCost) {
            minCost = cost;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        for (int t = 1, ts = IO.readInt(NoisyNeighbors.in); t <= ts; t++) {
            NoisyNeighbors.out.print("Case #");
            NoisyNeighbors.out.print(t);
            NoisyNeighbors.out.print(": ");
            new NoisyNeighbors().solve();
        }
        NoisyNeighbors.out.flush();
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
