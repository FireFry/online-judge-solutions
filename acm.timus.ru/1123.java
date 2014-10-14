import java.io.*;

public class Problem1123 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1123() {
		this(System.in, System.out);
	}

	public Problem1123(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1123().run();
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
		int n = 0;
		byte[] a = new byte[2003];
		while ((next = bufferedReader.read() - '0') >= 0 && next <= 9) {
			a[n++] = (byte) next;
		}
		int k = n / 2;
		while (k < n && a[k] == a[n - k - 1]) {
			k++;
		}
		if (k < n && a[k] >= a[n - k - 1]) {
			int i = (n - 1) / 2;
			while (a[i] == 9) {
				a[i] = 0;
				i--;
			}
			a[i]++;
		}
		for (int i = 0; i < n; i++) {
			out.print(a[i < n / 2 ? i : n - i - 1]);
		}
		out.println();
	}
}