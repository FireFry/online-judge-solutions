import java.io.*;

public class Solution {

    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws Exception {
        for (int t = readInt(); t > 0; t--) {
            int n = readInt();
            int k = readInt();
            int m = n / k;
            int d = n % k;
            long s = 0;
            for (int i = 0; i < k; i++) {
                int g = m + (i < d ? 1 : 0);
                n -= g;
                s += n * g;
            }
            out.println(s);
        }
        out.flush();
    }

    int readInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        new Solution().solve();
    }

}
