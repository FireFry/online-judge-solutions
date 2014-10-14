import java.io.*;

public class Problem1581 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1581() {
		this(System.in, System.out);
	}

	public Problem1581(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1581().run();
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
		int count = (int) readNumber();
		int current = -1;
		int currentCount = 0;
		for (int i = 0; i < count; i++) {
			int next = (int) readNumber();
			if (next != current) {
				if (currentCount > 0) {
					out.print(currentCount);
					out.print(' ');
					out.print(current);
					out.print(' ');
				}
				current = next;
				currentCount = 1;
			} else {
				++currentCount;
			}
		}
		out.print(currentCount);
		out.print(' ');
		out.println(current);
	}
}