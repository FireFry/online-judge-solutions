import java.io.*;

public class Problem1104 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1104() {
		this(System.in, System.out);
	}

	public Problem1104(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1104().run();
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
		int next;
		int sum = 0;
		int min = 1;
		while ((next = bufferedReader.read()) != -1) {
			int x;
		    if (next >= 'A' && next <= 'Z') {
				x = next - 'A' + 10;
			} else if (next >= '0' && next <= '9') {
				x = next - '0';
			} else {
				continue;
			}
			if (min < x) {
				min = x;
			}
			sum += x;
		}
		for (int k = min + 1; k <= 36; k++) {
			if (sum % (k - 1) == 0) {
				out.println(k);
				return;
			}
		}
		out.println("No solution.");
	}
}