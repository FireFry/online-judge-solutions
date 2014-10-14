import java.io.*;

public class Problem1683 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1683() {
		this(System.in, System.out);
	}

	public Problem1683(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1683().run();
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
	int[] a = new int[100];
	int n = 0;

	private void solve() throws Exception {
		int x = (int) readNumber();
		while (x > 1) {
			a[n] = x / 2;
			x -= a[n];
			n++;
		}
		out.println(n);
		for (int i = 0; i < n; i++) {
			out.print(a[i]);
			if (i == n - 1) {
				out.println();
			} else {
				out.print(' ');
			}
		}
	}
}