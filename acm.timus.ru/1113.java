import java.io.*;

public class Solution {
    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws IOException {
        int n = readInt();
        int m = readInt();

        double t = n;
        double r = 0;
        int k = 1;

        while (t * k > m && 3 * k < m) {
            t -= m / k;
            k += 2;
            r += m;
        }

        out.println((int) Math.ceil(r + t * k));
        out.flush();
    }

    int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}
