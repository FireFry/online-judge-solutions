import java.io.*;

public class Problem1931 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1931() {
		this(System.in, System.out);
	}

	public Problem1931(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1931().run();
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
		int min = (int) readNumber();
		int minId = 0;
		int count = 0;
		int maxCount = Integer.MIN_VALUE;
		int maxId = 0;
		for (int i = 1; i < n; i++) {
			int x = (int) readNumber();
			count++;
			if (x < min) {
				if (count > maxCount) {
					maxCount = count;
					maxId = minId;
				}
				min = x;
				minId = i;
				count = 1;
			}
		}
		if (count > maxCount) {
			maxCount = count;
			maxId = minId;
		}
		out.println(maxId + 1);
	}
}