import java.io.*;

public class Problem1106 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1106() {
		this(System.in, System.out);
	}

	public Problem1106(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1106().run();
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
	private int n;
	private boolean[][] a;
	private int[] b;
	private int firstCount = 0;

	private void solve() throws Exception {
		n = (int) readNumber();
		a = new boolean[n][n];
		b = new int[n];
		int x;

		for (int i = 0; i < n; i++) {
			while ((x = (int) readNumber()) != 0) {
				a[x - 1][i] = a[i][x - 1] = true;
			}
		}
		for (int i = 0; i < n; i++) {
			if (b[i] == 0) {
				dfs(i, 1);
			}
		}
		out.println(firstCount);
		for (int i = 0; i < n; i++) {
			if (b[i] == 1) {
				out.print(i + 1);
				firstCount--;
				if (firstCount == 0) {
					out.println();
				} else {
					out.print(' ');
				}
			}
		}
	}

	private void dfs(int i, int k) {
		b[i] = k;
		if (k == 1) {
			firstCount++;
		}
		for (int j = 0; j < n; j++) {
			if (a[i][j] && b[j] == 0) {
				dfs(j, 3 - k);
			}
		}
	}
}