import java.io.*;

public class Problem1178 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1178() {
		this(System.in, System.out);
	}

	public Problem1178(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1178().run();
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
	private static final int[] p = new int[] {3, 4, 2, 1};
	int[] id;
	int[] x;
	int[] y;

	private void solve() throws Exception {
		int n = (int) readNumber();
		id = new int[n];
		x = new int[n];
		y = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			x[i] = (int) readNumber();
			y[i] = (int) readNumber();
		}
		sort();
		for (int i = 0; i < n / 2; i++) {
			out.print(id[2 * i] + 1);
			out.print(' ');
			out.println(id[2 * i + 1] + 1);
		}
	}

	private void sort() {
		int heapSize = id.length;
		for (int i = heapSize / 2; i > 0; i--) {
			heapify(heapSize, i);
		}
		for (int i = heapSize; i > 1; i--) {
			swap(i, 1);
			heapSize--;
			heapify(heapSize, 1);
		}
	}

	private void heapify(int heapSize, int i) {
		int left = i << 1;
		int right = left + 1;
		int largest = i;
		if (left <= heapSize && isBigger(left, i)) {
			largest = left;
		}
		if (right <= heapSize && isBigger(right ,largest)) {
			largest = right;
		}
		if (largest != i) {
			swap(largest, i);
			heapify(heapSize, largest);
		}
	}

	private void swap(int i, int j) {
		int z = id[i - 1];
		id[i - 1] = id[j - 1];
		id[j - 1] = z;

		z = x[i - 1];
		x[i - 1] = x[j - 1];
		x[j - 1] = z;

		z = y[i - 1];
		y[i - 1] = y[j - 1];
		y[j - 1] = z;
	}

	private boolean isBigger(int i, int j) {
		return x[i - 1] > x[j - 1];
	}
}