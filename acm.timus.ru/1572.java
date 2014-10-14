import java.io.*;

public class Problem1572 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1572() {
		this(System.in, System.out);
	}

	public Problem1572(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1572().run();
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
        int type = (int) readNumber();
        int x = (int) readNumber();
        double max = max(type, x);
        int n = (int) readNumber();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (min((int) readNumber(), (int) readNumber()) <= max) {
                count++;
            }
        }
        out.println(count);
	}

    private double max(int type, int x) {
        switch (type) {
            case 1:
                return 4 * x * x;
            case 2:
                return 2 * x * x;
            default:
                return x * x;
        }
    }

    private double min(int type, int x) {
        switch (type) {
            case 1:
                return 4 * x * x;
            case 3:
                return 3 * x * x / 4.0;
            default:
                return x * x;
        }
    }
}
