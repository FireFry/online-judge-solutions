import java.io.*;

public class Problem1138 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1138() {
		this(System.in, System.out);
	}

	public Problem1138(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1138().run();
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
        int s = (int) readNumber();
        int delta = n - s;
        int[] a = new int[delta + 1];
        a[0] = 1;
        int i = 0;
        int max = 0;
        int maxPaymentHundred = n * 100;
        while (i < delta) {
            if (a[i] > 0) {
                int payment = i + s;
                int nextPaymentHundred;
                for (int j = 1; j <= 100 && (nextPaymentHundred = payment * (100 + j)) <= maxPaymentHundred; j++) {
                    if (nextPaymentHundred % 100 == 0) {
                        int k = nextPaymentHundred / 100 - s;
                        if (a[i] + 1 > a[k]) {
                            a[k] = a[i] + 1;
                        }
                    }
                }
            }
            i++;
            if (a[i] > a[max]) {
                max = i;
            }
        }
        out.println(a[max]);
	}
}
