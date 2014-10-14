import java.io.*;
import java.util.Locale;

public class Problem1885 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1885() {
		this(System.in, System.out);
	}

	public Problem1885(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1885().run();
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
        int h = (int) readNumber();
        int t = (int) readNumber();
        int v = (int) readNumber();
        int x = (int) readNumber();
        double min;
        double max;
        if (h >= t * x) {
            min = (1.0 * h - x * t) / (v - x);
            max = t;
        } else {
            min = 0;
            max = 1.0 * h / x;
        }
        out.format(Locale.US, "%.7f %.7f", min, max);
        out.println();
	}
}
