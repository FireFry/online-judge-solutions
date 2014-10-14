import java.io.*;

public class Problem1644 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1644() {
		this(System.in, System.out);
	}

	public Problem1644(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1644().run();
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
		int min = 2;
		int max = 10;
		for (int i = 0; i < n; i++) {
			int x = (int) readNumber();
			boolean isSatisfied = readWord().equals("satisfied");
			if (isSatisfied) {
				if (max > x) {
					max = x;
				}
			} else {
				if (min < x) {
					min = x;
				}
			}
		}
		if (min >= max) {
			out.println("Inconsistent");
		} else {
			out.println(max);
		}
	}
}