import java.io.*;

public class Problem1880 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1880() {
		this(System.in, System.out);
	}

	public Problem1880(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1880().run();
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

	private final int[][] a = new int[3][];

	private void solve() throws Exception {
		for (int i = 0; i < a.length; i++) {
			int count = (int) readNumber();
			a[i] = new int[count];
			for (int j = 0; j < count; j++) {
				a[i][j] = (int) readNumber();
			}
		}
		int[] b = new int[a.length];
		int total = 0;
		boolean reachedEnd = false;
		while (!reachedEnd) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < b.length; i++) {
				int val = a[i][b[i]];
				if (val < min) {
					min = val;
				}
				if (val > max) {
					max = val;
				}
			}
			if (min == max) {
				total++;
				for (int i = 0; i < b.length && !reachedEnd; i++) {
					b[i]++;
					reachedEnd |= b[i] >= a[i].length;
				}
			} else {
				for (int i = 0; i < b.length && !reachedEnd; i++) {
					while (b[i] < a[i].length && a[i][b[i]] < max) {
						b[i]++;
					}
					reachedEnd |= b[i] >= a[i].length;
				}
			}
		}
		out.println(total);
	}
}