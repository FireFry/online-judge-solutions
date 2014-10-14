import java.io.*;

public class Problem1336 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1336() {
		this(System.in, System.out);
	}

	public Problem1336(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1336().run();
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
		long n = (long) readNumber();
		long a[] = new long[32];
		int size = 0;
		int sqrt = (int) Math.sqrt(n);
		long x = n;
		for (int i = 2; x > 1 && i <= sqrt; i++) {
			while (x % i == 0) {
				a[size++] = i;
				x /= i;
			}
		}
		if (x > 1) {
			a[size++] = x;
		}
		long m = 1;
		long k = 1;
		int i = 0;
		while (i < size) {
			long ai = a[i];
			if (i + 1 < size && ai == a[i + 1]) {
				m *= ai;
				i += 2;
			} else {
				k *= ai;
				m *= ai * ai;
				i++;
			}
		}
		out.println(m);
		out.println(k);
	}
}