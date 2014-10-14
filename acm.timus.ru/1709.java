import java.io.*;

public class Problem1709 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1709() {
		this(System.in, System.out);
	}

	public Problem1709(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1709().run();
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
    int[][] b;
    char[][] r;
    int[] c;
    int d;
    int a;
    long sum;

	private void solve() throws Exception {
        int n = Integer.valueOf(bufferedReader.readLine());
        String[] prices = bufferedReader.readLine().split(" ");
        d = Integer.valueOf(prices[0]);
        a = Integer.valueOf(prices[1]);
        b = new int[n][n];
        r = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r[i][j] = '0';
            }
        }
        c = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = bufferedReader.read() - '0';
            }
            bufferedReader.readLine();
        }
        int t = 1;
        for (int i = 0; i < n; i++) {
            if (c[i] == 0) {
                rec(i, t++);
            }
        }
        boolean[] p = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            if (c[i] != c[0] && !p[c[i]]) {
                add(0, i);
                p[c[i]] = true;
            }
        }
        out.println(sum);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(r[i][j]);
                if (j >= n - 1) {
                    out.println();
                }
            }
        }
	}

    private void rec(int i, int t) {
        c[i] = t;
        for (int j = 0; j < b[i].length; j++) {
            if (b[i][j] == 1) {
                if (c[j] != 0) {
                    remove(i, j);
                } else {
                    b[i][j] = b[j][i] = 0;
                    rec(j, t);
                }
            }
        }
    }

    private void add(int i, int j) {
        r[i][j] = r[j][i] = 'a';
        sum += a;
    }

    private void remove(int i, int j) {
        b[i][j] = b[j][i] = 0;
        r[i][j] = r[j][i] = 'd';
        sum += d;
    }
}
