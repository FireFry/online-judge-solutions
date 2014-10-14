import java.io.*;
import java.math.BigInteger;

public class Problem1222 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1222() {
		this(System.in, System.out);
	}

	public Problem1222(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1222().run();
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
		if (n == 0) {
			out.println(0);
			return;
		}
		if (n <= 1) {
			out.println(1);
			return;
		}
		int startValue;
		int threeDegree;
		if (n % 3 == 0) {
			startValue = 1;
			threeDegree = n / 3;
		} else if (n % 3 == 1) {
			startValue = 4;
			threeDegree = (n - 4) / 3;
		} else {
			startValue = 2;
			threeDegree = (n - 2) / 3;
		}
		BigInteger res = BigInteger.valueOf(startValue);
		while (threeDegree > 0) {
			res = res.multiply(BigInteger.valueOf(3));
			threeDegree--;
		}
		out.println(res.toString());
	}
}