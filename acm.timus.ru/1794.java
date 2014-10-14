import java.io.*;

public class Problem1794 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1794() {
		this(System.in, System.out);
	}

	public Problem1794(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1794().run();
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
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[(2 + n + i - (int) readNumber()) % n]++;
		}
		int max = a[0];
		int maxId = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
				maxId = i;
			}
		}
		out.println(maxId == 0 ? n : maxId);
	}
}