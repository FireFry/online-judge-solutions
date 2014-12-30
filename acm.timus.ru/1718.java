import java.io.*;
import java.util.HashSet;

public class Solution {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws IOException {
        int n = readInt();
HashSet<String> a = new HashSet<String>(n);
        HashSet<String> authors = new HashSet<String>(n);
        for (int i = 0; i < n; i++) {
            String[] split = in.readLine().split(" ");
            if (split.length == 2 && split[1].equals("AC") || split.length == 3 && Integer.valueOf(split[2]) > 5) {
                authors.add(split[0]);
            }
if (split.length == 3 && Integer.valueOf(split[2]) > 6) {
                a.add(split[0]);
            }
        }
        out.print(a.size());
        out.print(" ");
        out.println(authors.size());
        out.flush();
    }

    int readInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}