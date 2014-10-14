import java.io.*;

public class Problem1711 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1711() {
		this(System.in, System.out);
	}

	public Problem1711(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1711().run();
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
		String[][] a = new String[n][3];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				String key = readWord();
				int k = j - 1;
				while (k >= 0 && a[i][k].compareTo(key) > 0) {
					a[i][k + 1] = a[i][k];
					k--;
				}
				a[i][k + 1] = key;
			}
		}
		String[] result = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			int k = (int) readNumber() - 1;
			if (i == 0) {
				result[i] = a[k][0];
			} else {
				int j = 0;
				while (j < a[k].length && a[k][j].compareTo(result[i - 1]) < 0) {
					j++;
				}
				if (j < a[k].length) {
					result[i] = a[k][j];
				} else {
					out.println("IMPOSSIBLE");
					return;
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
	}
}