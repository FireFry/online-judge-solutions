import java.io.*;

public class Problem1769 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1769() {
		this(System.in, System.out);
	}

	public Problem1769(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1769().run();
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
	int[] a = new int[6];
	int i = 0;
	boolean[] b = new boolean[10000001];

	private void solve() throws Exception {
		int next;
		while ((next = bufferedReader.read()) >= '0' && next <= '9') {
			a[i] = next - '0';
			int x = 0;
			int y = 1;
			for (int j = 0; j < a.length; j++) {
				x = x + a[(a.length + i - j) % a.length] * y;
				y *= 10;
				b[x] = true;
			}
			i = (i + 1) % a.length;
		}
		int i = 1;
		while (b[i] && i < b.length) {
			i++;
		}
		out.println(i);
	}
}