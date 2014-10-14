import java.io.*;

public class Problem1642 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1642() {
		this(System.in, System.out);
	}

	public Problem1642(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1642().run();
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
		int x = (int) readNumber();
		int y = Integer.MIN_VALUE;
		int z = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int k = (int) readNumber();
			if (k > 0) {
				if (k < z) {
					z = k;
				}
			} else {
				if (k > y) {
					y = k;
				}
			}
		}
		if (x > 0) {
			if (x > z) {
				out.println("Impossible");
				return;
			}
			out.print(x);
			out.print(' ');
			out.println(x - 2 * y);
		} else {
			if (x < y) {
				out.println("Impossible");
				return;
			}
			out.print(2 * z - x);
			out.print(' ');
			out.println(- x);
		}
	}
}