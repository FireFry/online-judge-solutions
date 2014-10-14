import java.io.*;

public class Problem1788 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1788() {
		this(System.in, System.out);
	}

	public Problem1788(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1788().run();
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
		int[] g = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int key = (int) readNumber();
			int j = i - 1;
			while (j >= 0 && g[j] > key) {
				g[j + 1] = g[j];
				j--;
			}
			g[j + 1] = key;
		}
		int[] b = new int[m + 1];
		for (int i = 0; i < m; i++) {
			int key = (int) readNumber();
			int j = i - 1;
			while (j >= 0 && b[j] > key) {
				b[j + 1] = b[j];
				j--;
			}
			b[j + 1] = key;
		}
		for (int i = 1; i < n + 1; i++) {
			g[i] += g[i - 1];
		}
		for (int i = 1; i < m; i++) {
			b[i] += b[i - 1];
		}
		int prev = 0;
		for (int i = 0; i <= m; i++) {
			int z = b[i];
			b[i] = prev * (m - i);
			prev = z;
		}
		int i = n;
		int j = m;
		int min = Integer.MAX_VALUE;
		while (i >= 0 && j >= 0) {
			int c = g[i] + b[j];
			if (min > c) {
				min = c;
			}
			i--;
			j--;
		}
		out.println(min);
	}
}