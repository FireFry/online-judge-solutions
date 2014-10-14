import java.io.*;

public class Problem1249 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1249() {
		this(System.in, System.out);
	}

	public Problem1249(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1249().run();
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
		byte[] a = new byte[m + 1];
		for (int i = 1; i <= m; i++) {
			a[i] = (byte) readNumber();
		}
		for (int i = 1; i < n; i++) {
			byte prev = 0;
			for (int j = 1; j <= m; j++) {
				byte cur = (byte) readNumber();
				if (cur + prev + a[j] + a[j - 1] == 3) {
					out.println("No");
					return;
				}
				a[j - 1] = prev;
				prev = cur;
			}
			a[m] = prev;
		}
		out.println("Yes");
	}
}