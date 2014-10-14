import java.io.*;

public class Problem1506 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1506() {
		this(System.in, System.out);
	}

	public Problem1506(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1506().run();
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
        int k = (int) readNumber();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) readNumber();
        }
        int rows = (int) Math.ceil(((double) n) / k);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < k; j++) {
                int index = i + j * rows;
                if (index < a.length) {
                    String val = String.valueOf(a[index]);
                    for (int z = 0; z < 4 - val.length(); z++) {
                        out.print(' ');
                    }
                    out.print(val);
                }
            }
            out.println();
        }
	}
}
