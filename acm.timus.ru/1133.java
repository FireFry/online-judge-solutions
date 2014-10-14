import java.io.*;

public class Problem1133 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1133() {
		this(System.in, System.out);
	}

	public Problem1133(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1133().run();
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

    public static final double SQRT_5 = Math.sqrt(5);
    public static final double FI = (1 + SQRT_5) / 2;
    public static final double LOG_FI = Math.log(FI);

	private void solve() throws Exception {
		int i = (int) readNumber();
        long fi = (long) readNumber();
        int j = (int) readNumber();
        long fj = (long) readNumber();
        int n = (int) readNumber();
        if (n == i) {
            out.println(fi);
            return;
        }
        if (n == j) {
            out.println(fj);
            return;
        }
        if (i > j) {
            int z = i; i = j; j = z;
            long fz = fi; fi = fj; fj = fz;
        }
        if (fi == fj && fi == 0) {
            out.println(0);
            return;
        }
        long fi1;
        if (j == i + 1) {
            fi1 = fj;
        } else {
            fi1 = Math.round((fj - (double) fibonacci(j - i - 2) * fi) / fibonacci(j - i - 1));
        }
        if (n > i) {
            if (i + 1 == n) {
                out.println(fi1);
            } else {
                out.println(fi1 * fibonacci(n - i - 1) + fi * fibonacci(n - i - 2));
            }
        } else {
            while (i != n) {
                long next = fi1 - fi;
                fi1 = fi;
                fi = next;
                i--;
            }
            out.println(fi);
        }
	}

    private static long fibonacci(int i) {
        return Math.round(Math.exp((i + 1) * LOG_FI) / SQRT_5);
    }
}
