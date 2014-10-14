import java.io.*;
import java.io.StreamTokenizer;

public class Solution {
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int[] a = new int[n];
        for (int i = 0, size = n + 1; i < size; i++) {
            int ai = readInt();
            int bi = readInt();
            int ci = readInt();
            a[ai - 1] += ci;
            if (bi < n) {
                a[bi] -= ci;
            }
        }
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += a[i];
            out.print(t);
            if (i < n - 1) {
                out.print(' ');
            } else {
                out.println();
            }
        }
        out.flush();
    }

    private static int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private static String readWord() throws IOException {
        in.nextToken();
        return in.sval;
    }
}
