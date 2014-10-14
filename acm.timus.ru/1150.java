import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class Problem1150 {
    private static final Map<Integer, Long> COEF = new TreeMap<Integer, Long>() {{
        put(0,          0L);
        put(1,          0L);
        put(10,         1L);
        put(100,        20L);
        put(1000,       300L);
        put(10000,      4000L);
        put(100000,     50000L);
        put(1000000,    600000L);
        put(10000000,   7000000L);
        put(100000000,  80000000L);
        put(1000000000, 900000000L);
    }};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.valueOf(in.readLine());
        long[] result = run(n, new long[10]);
        for (int i = 0; i < result.length; i++) {
            out.println(result[i]);
        }
        out.flush();
    }

    private static long[] run(int n, long[] dst) {
        int t = multiplier(n);
        int d = n / t;
        int m = n % t;
        dst[d] += m + 1;
        run0(m, dst, t / 10);
        run9(d - 1, 1, dst, t);
        t /= 10;
        while (t > 0) {
            run9(9, 1, dst, t);
            t /= 10;
        }
        return dst;
    }

    private static void run0(int n, long[] dst, int t) {
        if (t <= 0) {
            return;
        }
        int d = n / t;
        int m = n % t;
        dst[d] += m + 1;
        run0(m, dst, t / 10);
        run9(d - 1, 0, dst, t);
    }

    private static void run9(int d, int l, long[] dst, int t) {
        for (int i = d; i >= l; i--) {
            dst[i] += t;
        }
        if (d >= l) {
            for (int i = 0; i <= 9; i++) {
                dst[i] += (d + 1 - l) * COEF.get(t);
            }
        }
    }

    private static int multiplier(int n) {
        int t = 1;
        int t1;
        while ((t1 = t * 10) <= n) {
            t = t1;
        }
        return t;
    }
}
