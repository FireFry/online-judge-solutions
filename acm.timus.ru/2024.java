import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws IOException {
        String ss = in.readLine();
        int k = Integer.parseInt(in.readLine());

        int n = 'z' - 'a' + 1;
        int[] a = new int[n];
        for (int i = 0; i < ss.length(); i++) {
            a[ss.charAt(i) - 'a']++;
        }
        Arrays.sort(a);

        int[] b = new int[n];
        int[] c = new int[n];
        int s = 0;
        for (int i = a.length - 1; i >= 0 && a[i] > 0; i--) {
            if (s > 0 && b[s - 1] == a[i]) {
                c[s - 1]++;
            } else {
                s++;
                b[s - 1] = a[i];
                c[s - 1] = 1;
            }
        }

        int i = 0;
        int sum = 0;
        while (i < s && k >= c[i]) {
            k -= c[i];
            sum += b[i] * c[i];
            i++;
        }

        if (i < s && k > 0) {
            sum += b[i] * k;
            out.print(sum);
            out.print(' ');
            out.println(C(k, c[i]));
        } else {
            out.print(sum);
            out.println(" 1");
        }

        out.flush();
    }

    private BigInteger C(int k, int n) {
        return f(n).divide(f(k)).divide(f(n - k));
    }

    private BigInteger f(int n) {
        BigInteger x = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            x = x.multiply(BigInteger.valueOf(i));
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}
