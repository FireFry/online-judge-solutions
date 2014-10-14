import java.io.*;
import java.util.Arrays;

public class Problem1737 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1737() {
		this(System.in, System.out);
	}

	public Problem1737(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1737().run();
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
    String[] a = {
            "abc",
            "acb",
            "bac",
            "bca",
            "cab",
            "cba",
    };

	private void solve() throws Exception {
        int n = (int) readNumber();
        if (n * a.length > 100000) {
            out.println("TOO LONG");
            return;
        }
        if (n == 1) {
            out.println('a');
            out.println('b');
            out.println('c');
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int x = 0;
            String s = a[i];
            int length = s.length();
            while (x + length <= n) {
                out.print(s);
                x += 3;
            }
            if (x < n) {
                out.println(s.substring(0, n - x));
            } else {
                out.println();
            }
        }
	}
}
