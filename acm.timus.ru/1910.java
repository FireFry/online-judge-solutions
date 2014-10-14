import java.io.*;

public class Problem1910 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1910() {
		this(System.in, System.out);
	}

	public Problem1910(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1910().run();
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
		int[] a = new int[3];
		int n = (int) readNumber();
		int sum = 0;
		int maxSum = 0;
		int maxId = 1;
		for (int i = 0; i < n; i++) {
			if (i < a.length) {
				a[i] = (int) readNumber();
				sum += a[i];
				maxSum = sum;
			} else {
				int j = i % 3;
				sum -= a[j];
				a[j] = (int) readNumber();
				sum += a[j];
				if (sum > maxSum) {
					maxSum = sum;
					maxId = i - 1;
				}
			}
		}
		out.print(maxSum);
		out.print(' ');
		out.println(maxId + 1);
	}
}