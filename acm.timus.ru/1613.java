import java.io.*;
import java.util.*;

public class Problem1613 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1613() {
		this(System.in, System.out);
	}

	public Problem1613(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1613().run();
	}

	public void run() {
		try {
			solve();
			out.flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private double readNumber() throws IOException {
		int nextToken = in.nextToken();
		if (nextToken == StreamTokenizer.TT_NUMBER) {
			return in.nval;
		}
		throw new IllegalStateException("Number expected. Found: " + nextToken);
	}

	private String readWord() throws IOException {
		int nextToken = in.nextToken();
		if (nextToken == StreamTokenizer.TT_WORD) {
			return in.sval;
		}
		throw new IllegalStateException("Word expected. Found: " + nextToken);
	}

	private void solve() throws Exception {
        int n = (int) readNumber();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = ((long) readNumber()) * 100000 + i;
        }
        Arrays.sort(a);
        //sort(a, 15);
        for (int m = (int) readNumber(); m > 0; m--) {
            long min = (long) readNumber() - 1;
            long max = (long) readNumber() - 1;
            long x = (long) readNumber() * 100000;
            min += x;
            max += x;
            int l = 0;
            int r = n - 1;
            int i = (l + r) / 2;
            while (l <= r) {
                if (a[i] < min) {
                    l = i + 1;
                } else if (a[i] > max) {
                    r = i - 1;
                } else {
                    break;
                }
                i = (l + r) / 2;
            }
            out.print(l <= r ? 1 : 0);
        }
        out.println();
	}

    public static void sort(long[] a, int maxDigits) {
        int[] c = new int[10];
        long[] b = new long[a.length];
        long x = 1;
        for (int i = 0; i < maxDigits; i++) {
            for (int j = 0; j < c.length; j++) {
                c[j] = 0;
            }
            for (int j = 0; j < a.length; j++) {
                int digit = (int) ((a[j] / x) % 10);
                c[digit]++;
                b[j] = a[j];
            }
            for (int j = 1; j < c.length; j++) {
                c[j] += c[j - 1];
            }
            for (int j = b.length - 1; j >= 0; j--) {
                int digit = (int) ((b[j] / x) % 10);
                c[digit]--;
                a[c[digit]] = b[j];
            }
            x *= 10;
        }
    }
}
