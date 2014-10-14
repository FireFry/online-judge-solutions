import java.io.*;

public class Solution {
    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        new Solution().solveAndFlush();
    }

    void solveAndFlush() throws Exception {
        solve();
        out.flush();
    }

    void solve() throws Exception {
        int n = readInt();
        int[] c = new int[10000000];
        int maxc = 0;
        loop:
        for (int i = 0; i < n; i++) {
            int x = readInt();
            for (int j = 2; j * j <= x; j++) {
                if (x % j == 0) {
                    do {
                        x /= j;
                    } while (x % j == 0);
                    int count = c[j] + 1;
                    c[j] = count;
                    if (count > maxc) {
                        maxc = count;
                    }
                    if (maxc > 2) {
                        break loop;
                    }
                }
            }
            if (x > 1) {
                int count = c[x] + 1;
                c[x] = count;
                if (count > maxc) {
                    maxc = count;
                }
                if (maxc > 2) {
                    break loop;
                }
            }
        }
        out.print(maxc > 2 ? "infinity" : maxc);
    }

    int readInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }
}