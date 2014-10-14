import java.io.*;
import java.io.StreamTokenizer;

public class JavaSolution {
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        int[] a = new int[readInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = readInt();
        }
        int first = readInt() - 1;
        int second = readInt() - 1;
        int x;
        int y;
        if (first == second) {
            int left = sum(a, 0, first);
            int right = sum(a, first + 1, a.length);
            x = Math.max(left, right) + a[first];
            y = Math.min(left, right);
        } else if (first < second) {
            x = sum(a, 0, first);
            y = sum(a, second + 1, a.length);
            while (first < second) {
                x += a[first++];
                y += a[second--];
            }
            if (first == second) {
                x += a[first];
            }
        } else {
            x = sum(a, first + 1, a.length);
            y = sum(a, 0, second);
            while (first > second) {
                x += a[first--];
                y += a[second++];
            }
            if (first == second) {
                x += a[first];
            }
        }
        out.print(x);
        out.print(' ');
        out.println(y);
        out.close();
    }

    private static int sum(int[] a, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res += a[i];
        }
        return res;
    }

    private static int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}
