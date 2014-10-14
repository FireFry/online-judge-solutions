import java.io.*;

public class Problem1228 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1228() {
		this(System.in, System.out);
	}

	public Problem1228(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1228().run();
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
		int s = (int) readNumber();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = (int) readNumber();
		}
		for (int i = n - 1; i > 0; i--) {
			a[i] = a[i - 1] / a[i] - 1;
		}
		a[0] = s / a[0] - 1;
		for (int i = 0; i < n; i++) {
			out.print(a[i]);
			if (i == n - 1) {
				out.println();
			} else {
				out.print(' ');
			}
		}
	}
}