import java.io.*;
import java.util.Locale;

public class Problem1640 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1640() {
		this(System.in, System.out);
	}

	public Problem1640(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1640().run();
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
        double x0 = 0.5;
        double y0 = 0.5;
        double radius = 0;
        for (int i = 0; i < n; i++) {
            double x = readNumber();
            double y = readNumber();
            double distance = Math.sqrt((x0 - x) * (x0 - x) + (y0 - y) * (y0 - y));
            if (distance > radius) {
                radius = distance;
            }
        }
        out.format(Locale.US, "%.2f", x0);
        out.print(' ');
        out.format(Locale.US, "%.2f", y0);
        out.print(' ');
        out.format(Locale.US, "%.9f", radius);
        out.println();
	}
}
