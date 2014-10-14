import java.io.*;

public class Problem1134 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1134() {
		this(System.in, System.out);
	}

	public Problem1134(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1134().run();
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
        int m = (int) readNumber();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = (int) readNumber();
        }
        sort(a);
        boolean[] b = new boolean[n];
        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            if (key > 0 && !b[key - 1]) {
                b[key - 1] = true;
            } else if (key < b.length && !b[key]) {
                b[key] = true;
            } else {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
	}

    private void sort(int[] a) {
        int heapsize = a.length;
        for (int i = heapsize / 2; i >= 0; i--) {
            heapify(a, i, heapsize);
        }
        while (heapsize > 0) {
            heapsize--;
            swap(a, 0, heapsize);
            heapify(a, 0, heapsize);
        }
    }

    private void heapify(int[] a, int i, int heapsize) {
        int l = i * 2;
        int r = l + 1;
        int largest = i;
        if (l < heapsize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapsize && a[r] > a[largest]) {
            largest = r;
        }
        if (i != largest) {
            swap(a, i, largest);
            heapify(a, largest, heapsize);
        }
    }

    private void swap(int[] a, int i, int j) {
        int z = a[i];
        a[i] = a[j];
        a[j] = z;
    }
}
