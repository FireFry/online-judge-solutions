import java.io.*;
import java.util.Locale;

public class Problem1192 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1192() {
		this(System.in, System.out);
	}

	public Problem1192(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1192().run();
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
	private static final float PI = 3.1415926535f;

	private void solve() throws Exception {
		double v = readNumber();
		int a = (int) readNumber();
		double k = Math.sqrt(readNumber());
		double cosA = Math.cos(Math.toRadians(a));
		double sinA = Math.sin(Math.toRadians(a));
		double dx = 0;
		for (int i = 0; i < 1000000; i++) {
			double vx = (v * cosA);
			double vy = (v * sinA);
			double dt = 2 * vy / 10f;
			dx += vx * dt;
			v /= k;
		}
		out.format(Locale.US, "%.2f", dx);
	}
}