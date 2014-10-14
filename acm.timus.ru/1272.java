import java.io.*;

public class Problem1272 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1272() {
		this(System.in, System.out);
	}

	public Problem1272(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1272().run();
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
        int k = (int) readNumber();
        int m = (int) readNumber();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < k; i++) {
            int x = root(a, (int) readNumber() - 1);
            int y = root(a, (int) readNumber() - 1);
            if (x > y) {
                int z = x;
                x = y;
                y = z;
            }
            a[y] = x;
        }
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == i) {
                c++;
            }
        }
        out.println(c - 1);
	}

    private int root(int[] a, int i) {
        while (a[i] != i) {
            i = a[i];
        }
        return i;
    }
}
