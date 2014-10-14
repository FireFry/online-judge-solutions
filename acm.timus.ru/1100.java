import java.io.*;

public class Problem1100 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1100() {
		this(System.in, System.out);
	}

	public Problem1100(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1100().run();
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
		int[] m = new int[n];
		int[] c = new int[101];
		int[] b = new int[n];
		int[] d = new int[101];

		for (int i = 0; i < n; i++) {
			a[i] = (int) readNumber();
			m[i] = (int) readNumber();
			c[m[i]]++;
		}
		int id = 0;
		for (int i = c.length - 1; i >= 0; i--) {
			d[i] = id;
			id += c[i];
		}
		for (int i = 0; i < a.length; i++) {
			b[d[m[i]]] = i;
			d[m[i]]++;
		}
		for (int i = 0; i < b.length; i++) {
			out.print(a[b[i]]);
			out.print(' ');
			out.println(m[b[i]]);
		}
	}
}