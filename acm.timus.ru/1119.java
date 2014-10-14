import java.io.*;

public class Problem1119 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1119() {
		this(System.in, System.out);
	}

	public Problem1119(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1119().run();
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
	private static final float BORDER = 100f;
	private static final float FAST_WAY = BORDER * (float) Math.sqrt(2);
	private static final float SLOW_WAY = BORDER * 2;

	private void solve() throws Exception {
		int n = (int) readNumber();
		int m = (int) readNumber();
		boolean[][] a = new boolean[n + 1][m + 1];
		int k = (int) readNumber();
		for (int i = 0; i < k; i++) {
			a[(int) readNumber()][(int) readNumber()] = true;
		}
		float[][] b = new float[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			b[i][0] = BORDER * i;
		}
		for (int i = 0; i <= m; i++) {
			b[0][i] = BORDER * i;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				b[i][j] = Math.min(
						b[i - 1][j - 1] + (a[i][j] ? FAST_WAY : SLOW_WAY),
						Math.min(
								b[i - 1][j] + BORDER,
								b[i][j - 1] + BORDER
						)
				);
			}
		}
		out.println(Math.round(b[n][m]));
	}
}