import java.io.*;

public class Problem1727 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1727() {
		this(System.in, System.out);
	}

	public Problem1727(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1727().run();
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
	int[] a;
	int[] b;

	private void solve() throws Exception {
		a = new int[100000];
		b = new int[100000];
		boolean[] c = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
			int x = i;
			while (x > 0) {
				b[i] += x % 10;
				x /= 10;
			}
		}
		sort();
		int n = (int) readNumber();
		int count = 0;
		while (n > 0) {
			int j = a.length - 1;
			while (j >= 0 && !(b[j] <= n && !c[j])) {
				j--;
			}
			if (j >= 0) {
				c[j] = true;
				n -= b[j];
				count++;
			} else {
				out.println(-1);
				return;
			}
		}
		out.println(count);
		for (int i = 0; i < a.length && count > 0; i++) {
			if (c[i]) {
				out.print(a[i]);
				count--;
				if (count == 0) {
					out.println();
				} else {
					out.print(' ');
				}
			}
		}
	}

	private void sort() {
		int heapSize = a.length;
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
		int z = a[i - 1];
		a[i - 1] = a[j - 1];
		a[j - 1] = z;

		z = b[i - 1];
		b[i - 1] = b[j - 1];
		b[j - 1] = z;
	}

	private boolean isBigger(int i, int j) {
		return b[i - 1] > b[j - 1];
	}
}