import java.io.*;

public class Solution {
    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws IOException {
        in.nextToken();
        int n = (int) in.nval;

        boolean[][][] g = new boolean[2][n][n];
        while (in.nextToken() != StreamTokenizer.TT_WORD) {
            int child = (int) in.nval - 1;

            in.nextToken();
            int parent = (int) in.nval - 1;

            g[0][child][parent] = true;
            g[1][parent][child] = true;
        }

        boolean[] v = new boolean[n];
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            v[(int) in.nval - 1] = true;
        }

        boolean[] w = new boolean[n];
        boolean[][] c = new boolean[2][n];
        for (int k = 0; k < g.length; k++) {
            for (int i = 0; i < n; i++) {
                if (v[i] && !c[k][i]) {
                    rec(g[k], c[k], w, n, i);
                }
            }
        }

        boolean hasWritten = false;
        for (int i = 0; i < n; i++) {
            if (!w[i]) {
                if (hasWritten) {
                    out.print(' ');
                } else {
                    hasWritten = true;
                }
                out.print(i + 1);
            }
        }
        if (!hasWritten) {
            out.print(0);
        }
        out.println();

        out.flush();
    }

    private void rec(boolean[][] g, boolean[] c, boolean[] w, int n, int i) {
        c[i] = true;
        w[i] = true;
        for (int j = 0; j < n; j++) {
            if (g[i][j] && !c[j]) {
                rec(g, c, w, n, j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}