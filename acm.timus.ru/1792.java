import java.io.*;

public class Problem1792 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1792() {
		this(System.in, System.out);
	}

	public Problem1792(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1792().run();
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
		int[] a = new int[7];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) readNumber();
		}
		boolean isHamming = isHamming(a);
		for (int i = 0; !isHamming && i < a.length; i++) {
			a[i] = 1 - a[i];
			if (isHamming(a)) {
				isHamming = true;
			} else {
				a[i] = 1 - a[i];
			}
		}
		for (int i = 0; i < a.length; i++) {
			out.print(a[i]);
			if (i == a.length - 1) {
				out.println();
			} else {
				out.print(' ');
			}
		}
	}

	private boolean isHamming(int[] a) {
		int sum = 0;
		for (int i =0; i< a.length; i++) {
			if (i < 4) {
				sum += a[i];
			} else {
				if (a[i] != (sum - a[i - 4]) % 2) {
					return false;
				}
			}
		}
		return true;
	}
}