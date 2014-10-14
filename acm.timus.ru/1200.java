import java.io.*;
import java.util.Locale;

public class Problem1200 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1200() {
		this(System.in, System.out);
	}

	public Problem1200(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1200().run();
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
		double a = readNumber();
        double b = readNumber();
        int k = (int) readNumber();
        double res = 0;
        int x = 0;
        int y = 0;
        double temp;
        for (int x1 = 0; x1 <= k; x1++) {
            for (int y1 = 0; y1 <= k - x1; y1++) {
                if ((temp = f(a, b, x1, y1)) > res) {
                    res = temp;
                    x = x1;
                    y = y1;
                }
            }
        }
        out.format(Locale.US, "%.2f", res);
        out.println();
        out.print(x);
        out.print(' ');
        out.println(y);
    }

    private double f(double a, double b, int x, int y) {
        return x * (a - x) + y * (b - y);
    }
}