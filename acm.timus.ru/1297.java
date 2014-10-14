import java.io.*;

public class Problem1297 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1297() {
		this(System.in, System.out);
	}

	public Problem1297(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1297().run();
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
		String s = bufferedReader.readLine();
		int maxSize = 0;
		int start = 0;
		for (int i = 0; i < s.length() - maxSize; i++) {
			for (int size = s.length() - i; size > maxSize; size--) {
				if (isPolindrom(s, i, size)) {
					maxSize = size;
					start = i;
				}
			}
		}
		out.println(s.substring(start, start + maxSize));
	}

	private boolean isPolindrom(String s, int start, int size) {
		int i = start;
		int j = start + size - 1;
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}
		return i >= j;
	}
}