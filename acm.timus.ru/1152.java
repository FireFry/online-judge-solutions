import java.io.*;

public class Solution {
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int[] a = new int[n];
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) { a[i] = readInt(); }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, rec(a, b, a.length, i, (i + 2) % n, 0));
        }
        out.println(min);
        out.flush();
    }

    private static int rec(int[] a, boolean[] b, int n, int s, int f, int was) {
        was += distance(s, f, n);
        if (was == n) {
            return 0;
        }
        int j;
        int i = s;
        do {
            b[i] = true;
            j = i;
            i = next(i, n);
        } while (j != f);
        int sum = 0;
        for (int k = 0; k < n; k++) {
            if (!b[k]) {
                sum += a[k];
            }
        }
        int min = Integer.MAX_VALUE;
        for (;;) {
            while (b[i] && i != s) i = next(i, n);
            if (i == s) {
                break;
            }
            j = i;
            while (!b[next(j, n)]) {
                j = next(j, n);
            }
            int d = distance(i, j, n);
            if (d <= 3) {
                min = Math.min(min, rec(a, b, n, i, j, was));
            } else {
                for (int k = 0; k < d - 2; k++) {
                    min = Math.min(min, rec(a, b, n, i, (i + 2) % n, was));
                    i = next(i, n);
                }
            }
            i = next(j, n);
        }
        i = s;
        do {
            b[i] = false;
            j = i;
            i = next(i, n);
        } while (j != f);
        return sum + min;
    }

    private static int distance(int i, int j, int n) {
        int x = (j - i + 1 + n) % n;
        return x == 0 ? n : x;
    }

    private static int next(int i, int n) {
        return i == n - 1 ? 0 : i + 1;
    }

    private static int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}
