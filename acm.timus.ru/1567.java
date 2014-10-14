import java.io.*;

public class Problem1567 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1567() {
		this(System.in, System.out);
	}

	public Problem1567(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1567().run();
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
		int res = 0;
		char ch;
		while ((ch = (char) bufferedReader.read()) != -1 && ch != 10 && ch != 13) {
			res += count(ch);
		}
		out.println(res);
	}

	public int count(char ch) {
		switch (ch) {
			case 'a':
				return 1;
			case 'b':
				return 2;
			case 'c':
				return 3;
			case 'd':
				return 1;
			case 'e':
				return 2;
			case 'f':
				return 3;
			case 'g':
				return 1;
			case 'h':
				return 2;
			case 'i':
				return 3;
			case 'j':
				return 1;
			case 'k':
				return 2;
			case 'l':
				return 3;
			case 'm':
				return 1;
			case 'n':
				return 2;
			case 'o':
				return 3;
			case 'p':
				return 1;
			case 'q':
				return 2;
			case 'r':
				return 3;
			case 's':
				return 1;
			case 't':
				return 2;
			case 'u':
				return 3;
			case 'v':
				return 1;
			case 'w':
				return 2;
			case 'x':
				return 3;
			case 'y':
				return 1;
			case 'z':
				return 2;
			case '.':
				return 1;
			case ',':
				return 2;
			case '!':
				return 3;
			case ' ':
				return 1;
		}
		throw new IllegalArgumentException();
	}
}