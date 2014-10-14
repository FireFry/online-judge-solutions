import java.io.*;

public class Problem1869 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1869() {
		this(System.in, System.out);
	}

	public Problem1869(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1869().run();
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
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int number = (int) readNumber();
				if (i < j) {
					a[i] += number;
					a[j] -= number;
				} else {
					b[n - i - 1] += number;
					b[n - j - 1] -= number;
				}
			}
		}
		int maxCount = 0;
		for (int i = 0; i < n; i++) {
			if (i > 0) {
				a[i] += a[i - 1];
				b[i] += b[i - 1];
			}
			if (a[i] > maxCount) {
				maxCount = a[i];
			}
			if (b[i] > maxCount) {
				maxCount = b[i];
			}
		}
		out.println((int) Math.ceil(maxCount / 36f));
	}
}