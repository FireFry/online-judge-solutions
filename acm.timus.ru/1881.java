import java.io.*;

public class Problem1881 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1881() {
		this(System.in, System.out);
	}

	public Problem1881(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1881().run();
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
		int h = (int) readNumber();
		int w = (int) readNumber();
		int n = (int) readNumber();
		bufferedReader.readLine();
		int line = 1;
		int cymbal = -1;
		for (int i = 0; i < n; i++) {
			int length = bufferedReader.readLine().length();
			if (cymbal + 1 + length <= w) {
				cymbal += length + 1;
			} else {
				cymbal = length;
				++line;
			}
		}
		out.println((int) Math.ceil((float) line / h));
	}
}