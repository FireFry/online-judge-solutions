import java.io.*;
import java.io.StreamTokenizer;

public class Problem1998 {
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int m = readInt();
        int k = readInt();
        int[] a = new int[n];
        int[] b = new int[n + 1];
        int j = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int val = readInt();
            a[i] = val;
            sum += val;
            int nSum;
            while ((nSum = sum - a[j]) > k) {
                sum = nSum;
                j++;
            }
            b[i + 1] = j;
        }
        int i = 0;
        int p = 0;
        int t = 0;
        while (p < n) {
            int wi = i < m ? readInt() : Integer.MAX_VALUE;
            i++;
            int t1 = t + n - p;
            if (t1 < wi) {
                p = n;
                t = t1;
            } else {
                p = b[p + wi - t - 1];
                t = wi;
            }
        }
        out.println(t);
        out.flush();
    }

    private static int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}
