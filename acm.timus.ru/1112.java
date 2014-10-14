import java.io.*;

public class Problem1112 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1112() {
		this(System.in, System.out);
	}

	public Problem1112(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1112().run();
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
        int[][] a = new int[n][2];
        int[][] b = new int[n][];
        int size;
        for (int i = 0; i < n; i++) {
            int x = (int) readNumber();
            int y = (int) readNumber();
            if (x < y) {
                a[i][0] = x;
                a[i][1] = y;
            } else {
                a[i][1] = x;
                a[i][0] = y;
            }
        }
        for (int i = 1; i < n; i++) {
            int[] key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j][1] > key[1]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        size = 1;
        b[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] >= b[size - 1][1]) {
                b[size] = a[i];
                size++;
            }
        }
        out.println(size);
        for (int i = 0; i < size; i++) {
            out.print(b[i][0]);
            out.print(' ');
            out.println(b[i][1]);
        }
	}
}
