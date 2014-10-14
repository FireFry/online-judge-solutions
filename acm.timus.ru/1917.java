import java.io.*;

public class Problem1917 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1917() {
		this(System.in, System.out);
	}

	public Problem1917(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1917().run();
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
		int p = (int) readNumber();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = (int) readNumber();
		}
		sort(a);
		int i = 0;
		int tCount = 0;
		int gCount = 0;
		int k = 0;
		while (i < n && k * gCount <= p) {
			int count = 1;
			while (i + 1 < n && a[i + 1] == a[i]) {
				count++;
				i++;
			}
			if ((count + gCount) * a[i] <= p) {
				gCount += count;
				k = a[i];
			} else {
				tCount += gCount > 0 ? 1 : 0;
				k = a[i];
				gCount = count;
			}
			i++;
		}
		if (gCount > 0 && k * gCount <= p) {
			tCount++;
			gCount = 0;
		}
		out.print(i - gCount);
		out.print(' ');
		out.println(tCount);
	}

	private void sort(int[] a) {
		int heapSize = a.length;
		for (int i = heapSize / 2; i > 0; i--) {
			heapify(a, heapSize, i);
		}
		for (int i = heapSize; i > 1; i--) {
			swap(a, i, 1);
			heapSize--;
			heapify(a, heapSize, 1);
		}
	}

	private void heapify(int[] a, int heapSize, int i) {
		int left = i << 1;
		int right = left + 1;
		int largest = i;
		if (left <= heapSize && isBigger(a, left, i)) {
			largest = left;
		}
		if (right <= heapSize && isBigger(a, right ,largest)) {
			largest = right;
		}
		if (largest != i) {
			swap(a, largest, i);
			heapify(a, heapSize, largest);
		}
	}

	private void swap(int[] a, int i, int j) {
		int z = a[i - 1];
		a[i - 1] = a[j - 1];
		a[j - 1] = z;
	}

	private boolean isBigger(int[] a, int i, int j) {
		return a[i - 1] > a[j - 1];
	}
}