import java.io.*;

public class Problem1313 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1313() {
		this(System.in, System.out);
	}

	public Problem1313(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1313().run();
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
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = (int) readNumber();
			}
		}
		for (int i = 0; i < n * 2; i++) {
			int x = Math.min(i, n - 1);
			int y = Math.max(0, i - n + 1);
			while (x >= 0 && y < n) {
				out.print(a[x][y]);
				if (x == n - 1 && y == n - 1) {
					out.println();
				} else {
					out.print(' ');
				}
				--x;
				++y;
			}
		}
	}
}