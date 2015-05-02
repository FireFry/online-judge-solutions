import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static BufferedReader in = IO.lineInput();
    static PrintWriter out = IO.output();

    void solve() throws Exception {
        String a = in.readLine().split(" ")[1];
        for (int f = 0; ; f++) {
            if (matches(a, f)) {
                out.println(f);
                return;
            }
        }
    }

    boolean matches(String a, int p) {
        for (int i = 0; i < a.length(); i++) {
            int q = a.charAt(i) - '0';
            if (i > p) {
                return false;
            } else {
                p += q;
            }
        }
        return true;
    }
}

public class StandingOvation {
    public static void main(String[] args) throws Exception {
        for (int t = 1, ts = IO.readInt(Solution.in); t <= ts; t++) {
            Solution.out.print("Case #");
            Solution.out.print(t);
            Solution.out.print(": ");
            new Solution().solve();
        }
        Solution.out.flush();
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