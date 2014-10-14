import java.io.*;

public class Problem1987 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = readInt(in);
        int[][] a = new int[n + 2][2];

        a[0][0] = -1;
        a[0][1] = 2000000000;
        a[n + 1][0] = 2000000001;
        a[n + 1][1] = 2000000002;

        for (int i = 1; i <= n; i++) {
            a[i][0] = readInt(in);
            a[i][1] = readInt(in) + 1;
        }

        int[][] q = new int[n + 2][2];
        int qSize = 1;
        q[0][0] = 2000000000; q[0][1] = -1;

        int[][] b = new int[2 * n + 4][2];
        int bSize = 1;
        b[0][0] = -1;

        for (int i = 1; i <= n + 1; i++) {
            while (qSize > 0 && a[i][0] > q[qSize - 1][0]) {
                if (bSize == 0 || b[bSize - 1][0] != q[qSize - 1][0]) {
                    bSize++;
                    b[bSize - 1][0] = q[qSize - 1][0];
                }
                b[bSize - 2][1] = q[qSize - 1][1];
                qSize--;
            }
            if (qSize > 0 && b[bSize - 1][0] != a[i][0]) {
                bSize++;
                b[bSize - 1][0] = a[i][0];
                b[bSize - 2][1] = q[qSize - 1][1];
            }
            if (qSize > 0 && q[qSize - 1][0] == a[i][1]) {
                q[qSize - 1][1] = i;
            } else {
                qSize++;
                q[qSize - 1][0] = a[i][1];
                q[qSize - 1][1] = i;
            }
        }

        int m = readInt(in);
        int l = 0;
        for (int i = 0; i < m; i++) {
            int c = readInt(in);
            while (l < bSize - 1 && c >= b[l + 1][0]) {
                l++;
            }
            out.println(b[l][1]);
        }

        out.flush();
    }

    private static int readInt(StreamTokenizer in) throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}
