import java.io.*;

public class Problem1800 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1800() {
		this(System.in, System.out);
	}

	public Problem1800(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1800().run();
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
        int l = (int) readNumber();
        int h = (int) readNumber();
        int w = (int) readNumber();
        if (h <= l / 2) {
            out.println("butter");
            return;
        }
        double x = w * Math.sqrt((2.0 * h - l) / 981.0) / 60.0;
        x = x - (long) x;
        if (x > 0.25 && x < 0.75) {
            out.println("bread");
        } else {
            out.println("butter");
        }
    }
}
