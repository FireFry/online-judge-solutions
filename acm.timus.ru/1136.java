import java.io.*;

public class Problem1136 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1136() {
		this(System.in, System.out);
	}

	public Problem1136(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1136().run();
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
	int n;
	int[] a;

	private void solve() throws Exception {
		n = (int) readNumber();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = (int) readNumber();
		}
		rec(0, n);
	}

	private void rec(int from, int to) {
		to--;
		if (from > to) {
			return;
		}
		if (to - from > 0) {
			int i = from;
			while (i < to && a[i] < a[to]) {
				i++;
			}
			rec(i, to);
			rec(from, i);
		}
		out.print(a[to]);
		if (from == 0 && to == n - 1) {
			out.println();
		} else {
			out.print(' ');
		}
	}
}