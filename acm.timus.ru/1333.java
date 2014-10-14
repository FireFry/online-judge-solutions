import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Problem1333 {

    public static final int ITERATIONS = 1000;

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        double[] x = new double[n];
        double[] y = new double[n];
        double[] r2 = new double[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            x[i] = in.nval;
            in.nextToken();
            y[i] = in.nval;
            in.nextToken();
            r2[i] = in.nval * in.nval;
        }
        long count = 0;
        long total = ITERATIONS * ITERATIONS;
        for (int i = 0; i < ITERATIONS; i++) {
            for (int j = 0; j < ITERATIONS; j++) {
                double x1 = (i + 0.5d) / ITERATIONS;
                double y1 = (j + 0.5d) / ITERATIONS;
                int k = 0;
                while (k < n && distance2(x1, y1, x[k], y[k]) > r2[k]) {
                    k++;
                }
                if (k < n) {
                    count++;
                }
            }
        }
        out.println((double) count * (double) 100 / total);
        out.flush();
    }

    private static double distance2(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return dx * dx + dy * dy;
    }


}
