import java.io.*;
import java.util.Locale;

public class Problem1348 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1348() {
		this(System.in, System.out);
	}

	public Problem1348(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1348().run();
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
        double ax = readNumber();
        double ay = readNumber();
        double bx = readNumber();
        double by = readNumber();
        double cx = readNumber();
        double cy = readNumber();
        double l = readNumber();
        double ac2 = squaredDistance(ax, ay, cx, cy);
        double bc2 = squaredDistance(bx, by, cx, cy);
        double ab2 = squaredDistance(bx, by, ax, ay);
        double max = Math.max(0d, Math.sqrt(Math.max(ac2, bc2)) - l);
        double min;
        if (ac2 + ab2 <= bc2 || bc2 + ab2 <= ac2) {
            min = Math.sqrt(Math.min(ac2, bc2));
        } else {
            min = 0.5d  * Math.sqrt((4d * ab2 * ac2 - (ac2 + ab2 - bc2) * (ac2 + ab2 - bc2)) / ab2);
        }
        min = Math.max(0f, min - l);
        out.format(Locale.US, "%.2f", min);
        out.println();
        out.format(Locale.US, "%.2f", max);
        out.println();
    }

    private double squaredDistance(double x1, double y1, double x2, double y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
