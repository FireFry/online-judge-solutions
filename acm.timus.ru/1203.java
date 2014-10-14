import java.io.*;

public class Problem1203 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1203() {
		this(System.in, System.out);
	}

	public Problem1203(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1203().run();
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
	private int n;
	private int[] starts;
	private int[] ends;

	private void solve() throws Exception {
		n = (int) readNumber();
		starts = new int[n];
		ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = (int) readNumber();
			ends[i] = (int) readNumber();
		}
		sort();
		int count = 0;
		int lastEnd = 0;
		for (int i = 0; i < n; i++) {
			if (starts[i] > lastEnd) {
				count++;
				lastEnd = ends[i];
			}
		}
		out.println(count);
	}

	private void sort() {
		int heapSize = n;
		for (int i = n / 2; i >= 1; i--) {
			heapify(i, heapSize);
		}
		for (int i = n; i >= 2; i--) {
			swap(1, i);
			heapSize--;
			heapify(1, heapSize);
		}
	}

	private void swap(int i, int j) {
		int z = starts[i - 1];
		starts[i - 1] = starts[j - 1];
		starts[j - 1] = z;
		z = ends[i - 1];
		ends[i - 1] = ends[j - 1];
		ends[j - 1] = z;
	}

	private void heapify(int i, int heapSize) {
		int l = i << 1;
		int r = l + 1;
		int largest;
		if (l <= heapSize && ends[l - 1] > ends[i - 1]) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= heapSize && ends[r - 1] > ends[largest - 1]) {
			largest = r;
		}
		if (largest != i) {
			swap(i, largest);
			heapify(largest, heapSize);
		}
	}
}