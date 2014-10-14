import java.io.*;

public class Problem1796 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1796() {
		this(System.in, System.out);
	}

	public Problem1796(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1796().run();
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
	private static final int[] PRICES = {
			10,
			50,
			100,
			500,
			1000,
			5000,
	};

	private void solve() throws Exception {
		int min = 0;
		int sum = 0;
		for (int i = 0; i < PRICES.length; i++) {
			int count = (int) readNumber();
			if (count > 0 && min == 0) {
				min = PRICES[i];
			}
			sum += count * PRICES[i];
		}
		int ticket = (int) readNumber();
		int maxCount = sum / ticket;
		int minCount = (sum - min) / ticket + 1;
		out.println(maxCount - minCount + 1);
		for (int i = minCount; i <= maxCount; i++) {
			out.print(i);
			if (i == maxCount) {
				out.println();
			} else {
				out.print(' ');
			}
		}
	}
}