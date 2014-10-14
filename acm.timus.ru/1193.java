import java.io.*;

public class Problem1193 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1193() {
		this(System.in, System.out);
	}

	public Problem1193(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1193().run();
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
        int[][] t = new int[n][3];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = (int) readNumber();
            }
        }
        sort(t);
        int max = 0;
        int tc = 0;
        for (int i = 0; i < t.length; i++) {
            tc = Math.max(tc, t[i][0]) + t[i][1];
            max = Math.max(max, tc - t[i][2]);
        }
        out.println(max);
	}

    private void sort(int[][] t) {
        for (int i = 1; i < t.length; i++) {
            int[] key = t[i];
            int j = i - 1;
            while (j >= 0 && t[j][0] > key[0]) {
                t[j + 1] = t[j];
                j--;
            }
            t[j + 1] = key;
        }
    }
}
