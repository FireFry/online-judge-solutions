import java.io.*;

public class Solution {
    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws IOException {
        for (int t = readInt(); t > 0; t--) {
            int a = readInt();
            int b = readInt();
            if (b % a != 0) {
                out.println('0');
                continue;
            }
            b /= a;
            int l = 1;
            for (int i = 2; i * i <= b; i++) {
                while (b % i == 0) {
                    b /= i;
                    l++;
                }
            }
            if (b > 1) {
                l++;
            }
            out.println(l);
        }

        out.flush();
    }

    private int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}
