import java.io.*;

public class Problem1573 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1573() {
		this(System.in, System.out);
	}

	public Problem1573(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1573().run();
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
		int[] a = new int[3];
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) readNumber();
		}
		int k = (int) readNumber();
		for (int i = 0; i < k; i++) {
			b[readColor()]++;
		}
		long x = 1;
		for (int i = 0; i < a.length; i++) {
			if (b[i] > a[i]) {
				out.println(0);
				return;
			}
			long c = 1;
			for (int n = a[i]; n > a[i] - b[i]; n--) {
				c *= n;
			}
			for (int n = 2; n <= b[i]; n++) {
				c /= n;
			}
			x *= c;
		}
		out.println(x);
	}

	private int readColor() throws IOException {
		String s = readWord();
		if (s.equals("Blue")) {
			return 0;
		}
		if (s.equals("Red")) {
			return 1;
		}
		return 2;
	}
}