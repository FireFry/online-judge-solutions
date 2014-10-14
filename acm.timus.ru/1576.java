import java.io.*;

public class Problem1576 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1576() {
		this(System.in, System.out);
	}

	public Problem1576(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1576().run();
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
		int nextToken;
		while ((nextToken = in.nextToken()) != StreamTokenizer.TT_NUMBER && nextToken != StreamTokenizer.TT_EOF);
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
		int n1 = (int) readNumber();
		int c1 = (int) readNumber();
		int n2 = (int) readNumber();
		int t = (int) readNumber();
		int c2 = (int) readNumber();
		int n3 = (int) readNumber();
		int size = (int) readNumber();
		int totalMinutes = 0;
		for (int i = 0; i < size; i++) {
			int m = (int) readNumber() * 60 + (int) readNumber();
			if (m > 6) {
				totalMinutes += (int) Math.ceil(m / 60f);
			}
		}
		out.print("Basic:     ");
		out.println(n1 + c1 * totalMinutes);
		out.print("Combined:  ");
		out.println(n2 + Math.max(0, totalMinutes - t) * c2);
		out.print("Unlimited: ");
		out.println(n3);
	}
}