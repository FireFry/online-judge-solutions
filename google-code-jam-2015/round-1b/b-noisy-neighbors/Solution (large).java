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

    void solve() throws Exception {
        int r = in.readInt();
        int c = in.readInt();
        int n = in.readInt();

        int[] a = new int[4];

        if (r % 2 == 0) {
            if (c % 2 == 0) {
                a[0] = r * c / 2;
                a[2] = 2;
                a[3] = 2 * (r / 2 - 1 + c / 2 - 1);
            } else if (c == 1) {
                a[0] = r / 2;
                a[1] = 1;
                a[2] = r / 2 - 1;
            } else {
                a[0] = r * c / 2;
                a[2] = 2;
                a[3] = 2 * (r / 2 - 1) + (c - 1) / 2 + (c - 3) / 2;
            }
        } else {
            if (c % 2 == 0) {
                if (r == 1) {
                    a[0] = c / 2;
                    a[1] = 1;
                    a[2] = c / 2 - 1;
                } else {
                    a[0] = c * r / 2;
                    a[2] = 2;
                    a[3] = 2 * (c / 2 - 1) + (r - 1) / 2 + (r - 3) / 2;
                }
            } else {
                if (c == 1) {
                    a[0] = (r + 1) / 2;
                    a[2] = (r - 1) / 2;
                } else if (r == 1) {
                    a[0] = (c + 1) / 2;
                    a[2] = (c - 1) / 2;
                } else {
                    a[0] = (r - 1) * (c - 1) / 2 + (r - 1) / 2 + (c + 1) / 2;
                    a[3] = 2 * ((r - 1) / 2 + (c - 1) / 2);

                    long cost = 0;
                    int i = 0;
                    int nn = n;
                    while (nn > 0 && i < a.length) {
                        int x = Math.min(a[i], nn);
                        cost += i * x;
                        nn -= x;
                        i++;
                    }
                    cost += nn * 4;

                    a[0] = (r - 1) * (c - 1) / 2 + (r - 1) / 2 + (c - 1) / 2;
                    a[2] = 4;
                    a[3] = 2 * ((r - 3) / 2 + (c - 3) / 2);

                    long otherCost = 0;
                    i = 0;
                    while (n > 0 && i < a.length) {
                        int x = Math.min(a[i], n);
                        otherCost += i * x;
                        n -= x;
                        i++;
                    }
                    otherCost += n * 4;

                    out.println(Math.min(cost, otherCost));
                    return;
                }
            }
        }

        long cost = 0;
        int i = 0;
        while (n > 0 && i < a.length) {
            int x = Math.min(a[i], n);
            cost += i * x;
            n -= x;
            i++;
        }
        cost += n * 4;
        out.println(cost);
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
