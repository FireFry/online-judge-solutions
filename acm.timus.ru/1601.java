import java.io.*;

public class Problem1601 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1601() {
		this(System.in, System.out);
	}

	public Problem1601(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1601().run();
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
		char ch;
		boolean isSentence = false;
		while ((next = bufferedReader.read()) != -1) {
			ch = (char) next;
			if (isSentence) {
				if (ch == '.' || ch == '!' || ch == '?') {
					isSentence = false;
				} else if (ch >= 'A' && ch <='Z') {
					ch = Character.toLowerCase(ch);
				}
			} else {
				if (isAlphabetic(ch)) {
					ch = Character.toUpperCase(ch);
					isSentence = true;
				}
			}
			out.print(ch);
		}
	}

	private boolean isAlphabetic(char ch) {
		return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
	}
}