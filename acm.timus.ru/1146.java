import java.io.*;

public class Problem1146 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1146() {
		this(System.in, System.out);
	}

	public Problem1146(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1146().run();
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
		int[][] a = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + (int) readNumber();
			}
		}
		int maxSum = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = i; k <= n; k++) {
					for (int p = j; p <= n; p++) {
						int sum = a[i - 1][j - 1] + a[k][p] - a[i - 1][p] - a[k][j - 1];
						if (sum > maxSum) {
							maxSum = sum;
						}
					}
				}
			}
		}
		out.println(maxSum);
	}
}