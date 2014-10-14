import java.io.*;

public class Problem1330 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1330() {
		this(System.in, System.out);
	}

	public Problem1330(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1330().run();
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
	long[] a;

	private void solve() throws Exception {
		int n = (int) readNumber();
		a = new long[n];
		for (int i = 0; i < n; i++) {
			add(i, (int) readNumber());
		}
		int k = (int) readNumber();
		for (int i = 0; i < k; i++) {
			int start = (int) readNumber() - 1;
			int end = (int) readNumber() - 1;
			out.println(sum(end) - sum(start - 1));
		}
	}

	private long sum(int i) {
		long res = 0;
		for (; i >= 0; i -= (i + 1) & -(i + 1)) {
			res += a[i];
		}
		return res;
	}

	private void add(int i, int x) {
		for (; i < a.length; i += (i + 1) & -(i + 1)) {
			a[i] += x;
		}
	}
}