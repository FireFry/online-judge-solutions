import java.io.*;
import java.io.StreamTokenizer;

public class Solution {
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readInt() - 1;
        }
        boolean b[] = new boolean[n];
        int lcm = 1;
        for (int i = 0; i < n; i++) {
            if (!b[i]) {
                b[i] = true;
                int j = a[i];
                int k = 1;
                while (!b[j]) {
                    b[j] = true;
                    k++;
                    j = a[j];
                }
                lcm = lcm(lcm, k);
            }
        }
        out.println(lcm);
        out.flush();
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
