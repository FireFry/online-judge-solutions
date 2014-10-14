import java.io.*;

public class Problem1723 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1723() {
		this(System.in, System.out);
	}

	public Problem1723(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1723().run();
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
		String word = readWord();
		byte[] a = new byte['z' - 'a' + 1];
		for (int i =0 ; i < word.length(); i++) {
			a[word.charAt(i) - 'a']++;
		}
		int max = 0;
		for (int i = 1; i< a.length; i++) {
			if (a[i] > a[max]) {
				max = i;
			}
		}
		out.println((char)(max + 'a'));
	}
}