import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Problem1933 {

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(in.readLine()) * 2 + 1;
        int[][] a = new int[n][n];
        int offset = (n + 1) / 2 + 1;
        for (int i = 0; i < n; i++) {
            mark(a, 0, i, valueOf(i, offset));
        }
        for (int i = 0; i < n - 1; i++) {
            mark(a, i + 1, n - 1, valueOf(i, offset));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(i == j ? 0 : a[i][j]);
                if (j < n - 1) {
                    out.print(' ');
                } else {
                    out.println();
                }
            }
        }
        out.flush();
    }

    private static int valueOf(int i, int offset) {
        return (i % 2 == 0 ? 1 : offset) + i / 2;
    }

    private static void mark(int[][] a, int i, int j, int v) {
        while (i < a.length && j >= 0) {
            a[i++][j--] = v;
        }
    }

}
