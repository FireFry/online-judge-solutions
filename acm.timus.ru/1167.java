import java.io.*;

public class Problem1167 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1167() {
		this(System.in, System.out);
	}

	public Problem1167(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1167().run();
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
        int[] a = new int[n + 1];
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i - 1] + (int) readNumber();
        }
        int[][] b = new int[k + 1][n + 1];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = 1000000000;
            }
        }
        b[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                for (int q = 0; q <= j; q++) {
                    b[i][j] = Math.min(b[i][j], b[i - 1][q] + p(a, q, j));
                }
            }
        }
        out.println(b[k][n]);
	}

    private int p(int[] a, int i, int j) {
        int t = a[j] - a[i];
        return t * (j - i - t);
    }
}
