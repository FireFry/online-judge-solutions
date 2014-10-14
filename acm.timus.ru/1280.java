import java.io.*;

public class Problem1280 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1280() {
		this(System.in, System.out);
	}

	public Problem1280(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1280().run();
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
        boolean[][] a = new boolean[n][n];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) {
            int before = (int) readNumber() - 1;
            int after = (int) readNumber() - 1;
            a[before][after] = true;
        }
        for (int i = 0; i < n; i++) {
            b[i] = (int) readNumber() - 1;
            for (int j = 0; j < i; j++) {
                if (a[b[i]][b[j]]) {
                    out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");
	}
}
