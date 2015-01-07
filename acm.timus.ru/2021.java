import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws IOException {
        int n = (int) read();

        final int[] o = new int[n];
        Integer[] oi = new Integer[n];
        int os = 0;
        for (int i = 0; i < n; i++) {
            int val = (int) read();
            os += val;
            o[i] = val;
            oi[i] = i;
        }

        final int[] r = new int[n];
        Integer[] ri = new Integer[n];
        int rs = 0;
        for (int i = 0; i < n; i++) {
            int val = (int) read();
            rs += val;
            r[i] = val;
            ri[i] = i;
        }

        final int mult = (os > rs ? 1 : -1);
        Arrays.sort(oi, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return mult * Integer.compare(o[o1], o[o2]);
            }
        });

        Arrays.sort(ri, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -mult * Integer.compare(r[o1], r[o2]);
            }
        });

        for (int i = 0; i < n; i++) {
            out.print(oi[i] + 1);
            out.print(' ');
            out.println(ri[i] + 1);
        }

        out.flush();
    }

    private double read() throws IOException {
        in.nextToken();
        return in.nval;
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}