import java.io.*;
import java.io.StreamTokenizer;

public class Solution {
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        int m = readInt();
        int n = readInt();
        int[] dx = new int[76];
        int[] dy = new int[76];
        int dsize = 0;

        for (int x = 0; x < Math.max(m, n); x++) {
            for (int y = x; y < Math.max(m, n); y++) {
                if (matches(x, y)) {
                    dx[dsize] = x;
                    dy[dsize] = y;
                    dsize++;
                }
            }
        }

        boolean[][] a = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            String s = readWord();
            for (int y = 0; y < n; y++) {
                a[x][y] = s.charAt(y) == 'B';
            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (readInt() % 2 == 1) {
                    for (int i = 0; i < dsize; i++) {
                        int p = dx[i];
                        int q = dy[i];
                        if (p == 0) {
                            if (q == 0) {
                                flip(a, m, n, x, y);
                            } else {
                                flip(a, m, n, x, y - q);
                                flip(a, m, n, x - q, y);
                                flip(a, m, n, x, y + q);
                                flip(a, m, n, x + q, y);
                            }
                        } else {
                            if (q == 0) {
                                flip(a, m, n, x - p, y);
                                flip(a, m, n, x + p, y);
                                flip(a, m, n, x, y - p);
                                flip(a, m, n, x, y + p);
                            } else {
                                flip(a, m, n, x - p, y - q);
                                flip(a, m, n, x + p, y - q);
                                flip(a, m, n, x - q, y - p);
                                flip(a, m, n, x - q, y + p);

                                flip(a, m, n, x - p, y + q);
                                flip(a, m, n, x + p, y + q);
                                flip(a, m, n, x + q, y - p);
                                flip(a, m, n, x + q, y + p);
                            }
                        }
                    }
                }
            }
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                out.print(a[x][y] ? 'B' : 'W');
            }
            out.println();
        }
        out.flush();
    }

    private static void flip(boolean[][] a, int m, int n, int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            a[x][y] = !a[x][y];
        }
    }

    private static boolean matches(int x, int y) {
        double distance = Math.sqrt(x * x + y * y);
        return Math.abs(distance - Math.round(distance)) < 0.000001;
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
