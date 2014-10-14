import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String s = in.readLine();
        boolean[][] pl = new boolean[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                int j = i + l;
                pl[i][j] = i == j || s.charAt(i) == s.charAt(j) && (i + 1 == j || pl[i + 1][j - 1]);
            }
        }

        int[] a = new int[s.length()];
        int[] c = new int[s.length()];
        for (int j = 0; j < s.length(); j++) {
            if (pl[0][j]) {
                a[j] = 1;
                c[j] = 0;
            } else {
                a[j] = Integer.MAX_VALUE;
                for (int i = 0; i < j; i++) {
                    if (pl[i + 1][j]) {
                        int x = a[i] + 1;
                        if (x < a[j]) {
                            a[j] = x;
                            c[j] = i + 1;
                        }
                    }
                }
            }
        }

        String[] b = new String[s.length()];
        int bn = 0;
        int i = s.length();
        while (i > 0) {
            b[bn++] = s.substring(c[i - 1], i);
            i = c[i - 1];
        }

        out.println(bn);
        for (i = bn - 1; i >= 0; i--) {
            out.print(b[i]);
            if (i > 0) {
                out.print(' ');
            } else {
                out.println();
            }
        }

        out.println();
        out.flush();
    }
}