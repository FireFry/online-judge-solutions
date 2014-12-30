import java.io.*;

public class Solution {
    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws IOException {
        int n = readInt();
        int a = readInt();
        int b = readInt();

        int[] m = {a, b};
        int[][][] dp = new int[2][2][Math.max(m[0], m[1]) + 1];
        dp[0][0][0] = dp[0][0][1] = dp[0][1][0] = dp[0][1][1] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i % 2][j][0] = 0;
            }
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= m[j]; k++) {
                    int v = dp[(i - 1) % 2][j][k - 1];
                    dp[i % 2][j][k] = v;
                    dp[i % 2][1 - j][0] = mod(dp[i % 2][1 - j][0] + v);
                }
            }
        }

        out.println(mod(dp[(n - 1) % 2][0][0] + dp[(n - 1) % 2][1][0]));
        out.flush();
    }

    int mod(int x) {
        return x % 1000000007;
    }

    int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}
