import java.io.*;

public class Problem1645 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1645() {
		this(System.in, System.out);
	}

	public Problem1645(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1645().run();
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
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            int key = (int) readNumber() - 1;
            int biggerLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > key) {
                    biggerLeft++;
                }
            }
            b[key] = biggerLeft + 1;
            c[key] = n - key + i - biggerLeft;
            a[i] = key;
        }
        for (int i = 0; i < n; i++) {
            out.print(b[i]);
            out.print(' ');
            out.println(c[i]);
        }
	}
}
