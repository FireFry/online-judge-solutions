import java.io.*;

public class Solution {
    private StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    int[][] a;
    int[] b;
    boolean[] c;
    int[] parent;
    int[] size;
    int count;

    public static void main(String[] args) throws Exception {
        new Solution().solve();
    }

    public void solve() throws Exception {
        int n = readInt();
        int m = readInt();
        a = new int[m][2];
        for (int i = 0; i < m; i++) {
            a[i][0] = readInt() - 1;
            a[i][1] = readInt() - 1;
        }
        int q = readInt();
        b = new int[q];
        c = new boolean[m];
        for (int i = 0; i < q; i++) {
            b[i] = readInt() - 1;
            c[b[i]]= true;
        }
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
        for (int i = 0; i < m; i++) {
            if (!c[i]) {
                unite(a[i][0], a[i][1]);
            }
        }
        int[] results = new int[q];
        for (int i = 0; i < q; i++) {
            results[q - i - 1] = count;
            unite(a[b[q - i - 1]][0], a[b[q - i - 1]][1]);
        }
        for (int i = 0; i < q; i++) {
            out.print(results[i]);
            if (i < q - 1) {
                out.print(' ');
            } else {
                out.println();
            }
        }
        out.close();
    }

    private void unite(int a, int b) {
        a = leader(a);
        b = leader(b);
        if (a != b) {
            if (size[b] > size[a]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            size[a] += size[b];
            parent[b] = a;
            count--;
        }
    }

    private int leader(int x) {
        if (x == parent[x]) return x;
        parent[x] = leader(parent[x]);
        return parent[x];
    }

    private int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}
