import java.io.*;
import java.util.Arrays;

public class Problem1826 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1826() {
		this(System.in, System.out);
	}

	public Problem1826(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1826().run();
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) readNumber();
        }
        Arrays.sort(a);
        int[] b = new int[n];
        b[1] = f1(a, n);
        for (int i = 2; i < n; i++) {
            b[i] = Math.min(b[i - 2] + f2(a, n - i + 2), b[i - 1] + f1(a, n - i + 1));
        }
        out.println(b[n - 1]);
    }

    private int f1(int[] b, int n) {
        if (n <= 2) {
            return b[n - 1];
        }
        return b[n - 1] + b[0];
    }

    private int f2(int[] b, int n) {
        if (n < 4) {
            return 10000000;
        }
        return b[1] + b[0] + b[n - 1] + b[1];
    }
}
