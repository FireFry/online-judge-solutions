import java.io.*;

public class Problem1864 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1864() {
		this(System.in, System.out);
	}

	public Problem1864(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1864().run();
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

	//TODO global variables

	private void solve() throws Exception {
		int n = (int) readNumber();
		long[] a = new long[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = (long) readNumber();
			sum += a[i];
		}
		long sum2 = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Math.max(a[i] * (n + 1) - sum, 0L);
			sum2 += a[i];
		}
		for (int i = 0; i < n; i++) {
			out.print(100 * a[i] / sum2);
			if (i == n - 1) {
				out.println();
			} else {
				out.print(' ');
			}
		}
	}
}