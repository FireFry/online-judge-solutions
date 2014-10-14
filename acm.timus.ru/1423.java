import java.io.*;
import java.util.Collection;

public class Problem1423 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1423() {
		this(System.in, System.out);
	}

	public Problem1423(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1423().run();
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
		int n = Integer.valueOf(bufferedReader.readLine());
        char[] p = new char[n];
        char[] t = new char[n];
        bufferedReader.read(p);
        bufferedReader.readLine();
        bufferedReader.read(t);
        out.println(search(t, p, new int[n]));
	}

    public static int search(char[] t, char[] p, int[] pi) {
        computePrefixFunction(p, pi);
        int q = 0;
        for (int i = 0; i < t.length * 2 - 1; i++) {
            while (q > 0 && p[q] != t[i % t.length]) {
                q = pi[q - 1];
            }
            if (p[q] == t[i % t.length]) {
                q++;
            }
            if (q == p.length) {
                return i + 1 - p.length;
            }
        }
        return -1;
    }

    private static int[] computePrefixFunction(char[] p, int[] pi) {
        int k = 0;
        for (int q = 1; q < p.length; q++) {
            while (k > 0 && p[k] != p[q]) {
                k = pi[k - 1];
            }
            if (p[k] == p[q]) {
                k++;
            }
            pi[q] = k;
        }
        return pi;
    }

}
