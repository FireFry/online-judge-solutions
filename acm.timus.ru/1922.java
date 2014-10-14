import java.io.*;
import java.util.Random;

public class Problem1922 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1922() {
		this(System.in, System.out);
	}

	public Problem1922(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1922().run();
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
	Random rand = new Random();

	private void solve() throws Exception {
		int n = (int) readNumber();
		int[] a = new int[n + 1];
		int[] b = new int[n + 1];
		int[] c = new int[n];
		int cSize = 0;
		for (int i = 0; i < n; i++) {
			a[i] = (int) readNumber();
			b[i] = i + 1;
		}
		a[n] = n + 2;
		b[n] = -1;
		sort(a, b);
		for (int i = 1; i < a.length; i++) {
			if (a[i] > i + 1 && a[i - 1] <= i) {
				c[cSize++] = i;
			}
		}
		out.println(cSize);
		for (int i = 0; i < cSize; i++) {
			out.print(c[i]);
			for (int j = 0; j < c[i]; j++) {
				out.print(' ');
				out.print(b[j]);
			}
			out.println();
		}
	}

	private void sort(int[] a, int[] b) {
		quickSort(a, b, 0, a.length - 1);
	}

	private void quickSort(int[] a, int[] b, int p, int r) {
		if (p < r) {
			int q = randomPartition(a, b, p, r);
			quickSort(a, b, p, q - 1);
			quickSort(a, b, q + 1, r);
		}
	}

	private int randomPartition(int[] a, int[] b, int p, int r) {
		int i = p + rand.nextInt(r - p + 1);
		swap(a, b, i, r);
		return partition(a, b, p, r);
	}

	private int partition(int[] a, int[] b, int p, int r) {
		int key = a[r];
		int i = p;
		for (int j = p; j < r; j++) {
			if (a[j] <= key) {
				swap(a, b, i, j);
				i++;
			}
		}
		swap(a, b, i, r);
		return i;
	}

	private void swap(int[] a, int[] b, int i, int j) {
		int key;
		key = a[i];
		a[i] = a[j];
		a[j] = key;
		key = b[i];
		b[i] = b[j];
		b[j] = key;
	}
}