import java.io.*;

public class Solution {

    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws Exception {
        int x = readInt();
        int y = readInt();
        int c = readInt();
        if (x + y < c) {
            out.println("Impossible");
        } else {
            int a = Math.min(x, c);
            out.print(a);
            out.print(' ');
            out.println(c - a);
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
