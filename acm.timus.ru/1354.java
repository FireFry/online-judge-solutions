import java.io.*;

public class Problem1354 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1354() {
		this(System.in, System.out);
	}

	public Problem1354(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1354().run();
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
        String s = bufferedReader.readLine();
        int i = 1;
        while (i < s.length() && !isPolindrom(s, i, s.length() - 1)) {
            i++;
        }
        out.print(s);
        while (i > 0) {
            i--;
            out.print(s.charAt(i));
        }
        out.println();
	}

    private boolean isPolindrom(String s, int l, int r) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }
}
