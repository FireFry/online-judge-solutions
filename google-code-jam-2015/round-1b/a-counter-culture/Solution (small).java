import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class InfiniteHouseOfPancakes {
    static BufferedReader in = IO.lineInput();
    static PrintWriter out = IO.output();

    Queue<BigInteger> queue = new LinkedList<>();
    Queue<Integer> steps = new LinkedList<>();
    Set<BigInteger> enqueued = new HashSet<>();

    void solve() throws Exception {
        BigInteger bigInteger = new BigInteger(in.readLine());
        System.out.println(bigInteger);
        enqueue(bigInteger, 1);
        while (!queue.isEmpty()) {
            BigInteger x = queue.poll();
            Integer step = steps.poll();
            if (x.equals(BigInteger.ONE)) {
                out.println(step);
                return;
            }
            enqueue(x.subtract(BigInteger.ONE), step + 1);
            if (!x.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
                enqueue(reverse(x), step + 1);
            }
        }
    }

    private BigInteger reverse(BigInteger x) {
        StringBuilder sb = new StringBuilder(x.toString());
        sb.reverse();
        return new BigInteger(sb.toString());
    }

    private void enqueue(BigInteger val, Integer step) {
        if (!enqueued.contains(val)) {
            enqueued.add(val);
            queue.add(val);
            steps.add(step);
        }
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
