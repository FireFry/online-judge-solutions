import java.io.*;

public class Problem1731 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1731() {
		this(System.in, System.out);
	}

	public Problem1731(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1731().run();
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
		int m = (int) readNumber();
		for (int i = 1; i <= n; i++) {
			out.print(i);
			if (i == n) {
				out.println();
			} else {
				out.print(' ');
			}
		}
		for (int i = 1; i <= m; i++) {
			out.print(1 + i * n);
			if (i == m) {
				out.println();
			} else {
				out.print(' ');
			}
		}
	}
}