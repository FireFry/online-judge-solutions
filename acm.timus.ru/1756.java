import java.io.*;

public class Problem1756 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1756() {
		this(System.in, System.out);
	}

	public Problem1756(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1756().run();
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
		int m = (int) readNumber();
		int d1 = (int) readNumber();
		int d2 = (int) readNumber();
		int k = (int) Math.ceil(1f * m * d1 / d2);
		m *= d1;
		for (int i = 0; i < d2; i++) {
			out.print(Math.min(k, m));
			m = Math.max(0, m - k);
			if (i == d2 - 1) {
				out.println();
			} else {
				out.print(' ');
			}
		}
	}
}