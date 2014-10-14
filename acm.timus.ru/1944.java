import java.io.*;

public class Problem1944 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1944() {
		this(System.in, System.out);
	}

	public Problem1944(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1944().run();
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
        char[][] a = createBasicGraphic();
        int minX = index(0);
        int maxX = index(0);
        int minY = index(0);
        int maxY = index(0);
        for (int i = 0; i < n; i++) {
            int x = index((int) readNumber());
            int y = index((int) readNumber());
            a[x][y]='*';
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
        for (int j = maxY; j >= minY; j--) {
            for (int i = minX; i <= maxX; i++) {
                out.print(a[i][j]);
            }
            out.println();
        }
    }

    private char[][] createBasicGraphic() {
        char[][] a = new char[201][201];
        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a[x].length; y++) {
                a[x][y] = '.';
                if (pos(x) == 0) {
                    a[x][y] = '|';
                }
                if (pos(y) == 0) {
                    a[x][y] = '-';
                }
                if (pos(x) == 0 && pos(y) == 0) {
                    a[x][y] = '+';
                }
            }
        }
        return a;
    }

    private int pos(int i) {
        return i - 100;
    }

    private int index(int x) {
        return x + 100;
    }
}
