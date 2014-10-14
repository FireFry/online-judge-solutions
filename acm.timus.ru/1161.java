import java.io.*;
import java.util.Locale;

public class Problem1161 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1161() {
		this(System.in, System.out);
	}

	public Problem1161(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1161().run();
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
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			int key = (int) readNumber();
			int j = i - 1;
			while (j >= 0 && a[j] < key) {
				a[j + 1] = a[j];
				--j;
			}
			a[j + 1] = key;
		}
		double x = a[0];
		for (int i = 1; i < n; i++) {
			x = 2 * Math.sqrt(x * a[i]);
		}
		out.format(Locale.US, "%.2f", x);
	}
}