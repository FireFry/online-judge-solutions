import java.io.*;

public class Problem1196 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1196() {
		this(System.in, System.out);
	}

	public Problem1196(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1196().run();
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

	private int n;
	private int[] a;

	private void solve() throws Exception {
		int m;
		int count = 0;

		n = (int) readNumber();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = (int) readNumber();
		}
		m = (int) readNumber();
		for (int i = 0; i<m; i++) {
			if (find((int) readNumber())) {
				count++;
			}
		};
		out.println(count);
	}

	private boolean find(int x) {
		int lowerBound = 0;
		int upperBound = n - 1;
		while (lowerBound <= upperBound) {
			int mid = (lowerBound + upperBound) / 2;
			if (a[mid] == x) {
				return true;
			}
			if (a[mid] < x) {
				lowerBound = mid + 1;
			} else {
				upperBound = mid - 1;
			}
		}
		return false;
	}
}