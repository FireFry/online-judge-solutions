import java.io.*;

public class Problem1656 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1656() {
		this(System.in, System.out);
	}

	public Problem1656(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1656().run();
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
        int[] b = new int[n * n];
        for (int i = 0; i < b.length; i++) {
            b[i] = (int) readNumber();
        }
        for (int i = 1; i < b.length; i++) {
            int key = b[i];
            int j = i - 1;
            while (j >= 0 && b[j] < key) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = key;
        }
        int[][] a = new int[n][n];
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            int x = getIndex(i, a.length);
            for (int j = 0; j < a.length; j++) {
                int y = getIndex(j, a.length);
                a[x][y] = b[c++];
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                out.print(a[i][j]);
                if (j < a[i].length - 1) {
                    out.print(' ');
                } else {
                    out.println();
                }
            }
        }
	}

    private static int getIndex(int i, int n) {
        return n / 2 + (i % 2 == 0 ? +1 : -1) * (i + 1) / 2;
    }
}
