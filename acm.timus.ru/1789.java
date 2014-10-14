import java.io.*;

public class Problem1789 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1789() {
		this(System.in, System.out);
	}

	public Problem1789(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1789().run();
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
		if (n <= 3) {
			out.println("2");
			out.println("2 2");
			return;
		}
		out.println(2 * (n - 2) + 2 - n % 2);
		out.print("2 2 ");
		int i = 3;
		out.print(i);
		out.print(' ');
		while (i <= n - 2) {
			out.print(++i);
			out.print(' ');
		}
		int last = 2 - (n + 1) % 2;
		while (i >= last) {
			out.print(i);
			if (i == last) {
				out.println();
			} else {
				out.print(' ');
			}
			i--;
		}
	}
}