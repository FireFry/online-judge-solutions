import java.io.*;

public class Problem1929 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1929() {
		this(System.in, System.out);
	}

	public Problem1929(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1929().run();
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
        boolean isHoldenTeddyhater = false;
        for (int i = 0; i < m; i++) {
            if ((int) readNumber() == 1) {
                isHoldenTeddyhater = true;
                break;
            }
        }
        n -= m;
        if (isHoldenTeddyhater) {
            m--;
        } else {
            n--;
        }
        // m - other teddyhaters; n - other not teddyhaters
        int minT = 0;
        int maxT = Math.min(2, m);
        if (!isHoldenTeddyhater) {
            minT = 1;
        }
        while (maxT > 0 && 2 * (m - maxT) < n - 2 + maxT) {
            maxT--;
        }
        long sum = 0;
        for (int t = minT; t <= maxT; t++) {
            if (t <= m && 2 - t <= n && 2 * (m - t) >= n - 2 + t) {
                sum += funcC(t, m) * funcC(2 - t, n);
            }
        }
        out.println(sum);
    }

    private long funcC(int x, int y) {
        long res = 1;
        for (int i = y - x + 1; i <= y; i++) {
            res *= i;
        }
        for (int i = 2; i <= x; i++) {
            res /= i;
        }
        return res;
    }
}
