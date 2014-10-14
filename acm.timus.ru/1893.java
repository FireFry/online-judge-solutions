import java.io.*;

public class Problem1893 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1893() {
		this(System.in, System.out);
	}

	public Problem1893(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1893().run();
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

	public static final String WINDOW = "window";
	public static final String AISLE = "aisle";
	public static final String NEITHER = "neither";

	private void solve() throws Exception {
		int number = (int) readNumber();
		char seat = readWord().charAt(0);
		if (number <= 2) {
			//premium
			switch (seat) {
				case 'A':
				case 'D':
					out.println(WINDOW);
					return;
				default:
					out.println(AISLE);
					return;
			}
		} else if (number <= 20) {
			//buisenes
			switch (seat) {
				case 'A':
				case 'F':
					out.println(WINDOW);
					return;
				default:
					out.println(AISLE);
					return;
			}
		} else {
			//econome
			switch (seat) {
				case 'A':
				case 'K':
					out.println(WINDOW);
					return;
				case 'C':
				case 'D':
				case 'G':
				case 'H':
					out.println(AISLE);
					return;
				default:
					out.println(NEITHER);
					return;
			}
		}
	}
}