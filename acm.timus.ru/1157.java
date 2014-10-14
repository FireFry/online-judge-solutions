import java.io.*;

public class Problem1157 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1157() {
		this(System.in, System.out);
	}

	public Problem1157(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1157().run();
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
		int m = (int) readNumber();
		int k = (int) readNumber();
		int[] a = new int[10000];
		for (int i = 0; i < a.length; i++) {
			int count = 0;
			int sqrt = (int) Math.sqrt(i);
			for (int j = 1; j <= sqrt; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			a[i] = count;
		}
		for (int i = k; i < a.length; i++) {
			if (a[i] == m && a[i - k] == n) {
				out.println(i);
				return;
			}
		}
		out.println(0);
		return;
	}
}