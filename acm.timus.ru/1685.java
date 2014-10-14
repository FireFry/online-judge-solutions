import java.io.*;

public class Problem1685 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1685() {
		this(System.in, System.out);
	}

	public Problem1685(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1685().run();
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
	char[] a;
	String line;

	private void solve() throws Exception {
		line = bufferedReader.readLine();
		a = new char[line.length()];
		rec(0, 0, a.length);
		out.write(a);
		out.println();
	}

	private void rec(int x, int y, int length) {
		if (length == 0) {
			return;
		}
		int mid = x + (length - 1) / 2;
		a[mid] = line.charAt(y);
		int size = (length - 1) / 2;
		rec(x, y + 1, size);
		rec(mid + 1, y + 1 + size, length - 1 - size);
	}
}