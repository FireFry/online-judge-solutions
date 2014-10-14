import java.io.*;

public class Problem1352 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1352() {
		this(System.in, System.out);
	}

	public Problem1352(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1352().run();
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
	private static final long[] a = new long[] {
			2,
			3,
			5,
			7,
			13,
			17,
			19,
			31,
			61,
			89,
			107,
			127,
			521,
			607,
			1279,
			2203,
			2281,
			3217,
			4253,
			4423,
			9689,
			9941,
			11213,
			19937,
			21701,
			23209,
			44497,
			86243,
			110503,
			132049,
			216091,
			756839,
			859433,
			1257787,
			1398269,
			2976221,
			3021377,
			6972593,
	};

	private void solve() throws Exception {
		int n = (int) readNumber();
		for (int i = 0; i < n; i++) {
			out.println(a[(int) readNumber() - 1]);
		}
	}
}