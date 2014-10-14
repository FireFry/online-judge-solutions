import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Problem1122 {

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] a = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            String line = in.readLine();
            for (int j = 0; j < 4; j++) {
                a[i][j] = line.charAt(j) == 'W';
            }
        }
        boolean[][] b = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            String line = in.readLine();
            for (int j = 0; j < 3; j++) {
                b[i][j] = line.charAt(j) == '1';
            }
        }
        boolean[][] c = new boolean[4][4];
        int best = Integer.MAX_VALUE;
        for (int k = 0; k < 65536; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    c[i][j] = a[i][j];
                }
            }
            int x = 1;
            int swaps = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((k & x) > 0) {
                        apply(c, b, i, j);
                        swaps++;
                    }
                    x *= 2;
                }
            }
            boolean p = c[0][0];
            boolean isWin = true;
            for (int i = 0; isWin && i < 4; i++) {
                for (int j = 0; isWin && j < 4; j++) {
                    if (c[i][j] != p) {
                        isWin = false;
                    }
                }
            }
            if (isWin && best > swaps) {
                best = swaps;
            }
        }
        if (best == Integer.MAX_VALUE) {
            out.println("Impossible");
        } else {
            out.println(best);
        }
        out.flush();
    }

    private static void apply(boolean[][] c, boolean[][] b, int i, int j) {
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ii = i + di;
                int jj = j + dj;
                if (ii >= 0 && ii < 4 && jj >= 0 && jj < 4 && b[di + 1][dj + 1]) {
                    c[ii][jj] = !c[ii][jj];
                }
            }
        }
    }

}
