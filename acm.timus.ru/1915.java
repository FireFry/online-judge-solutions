import java.io.*;

public class Problem1915 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1915() {
		this(System.in, System.out);
	}

	public Problem1915(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1915().run();
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
		int[] b = new int[n];
		int m = 0;
		for (int i = 0; i < n; i++) {
			b[i] = (int) readNumber();
			if (b[i] == -1) {
				m++;
			}
		}
		int[] a = new int[n];
		int size = 0;
		for (int k = 0; k < n && m > 0; k++) {
			int x = b[k];
			if (x == -1) {
				out.println(a[--size]);
				m--;
			} else if (x == 0) {
				if (size < m) {
					int newSize = Math.min(m, size * 2);
					boolean isDoubled = newSize == size * 2;
					for (int i = 0; i < newSize && (!isDoubled || i < size); i++) {
						a[newSize - i - 1] = a[size - i - 1 + (i < size ? 0 : newSize)];
					}
					size = newSize;
				}
			} else {
				a[size++] = x;
			}
		}
	}
}