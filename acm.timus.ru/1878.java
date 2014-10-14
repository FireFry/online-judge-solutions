import java.io.*;

public class Problem1878 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1878() {
		this(System.in, System.out);
	}

	public Problem1878(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1878().run();
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
		int[][] a = new int[4][4];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) readNumber();
			}
		}
		int[] b = new int[] {
				a[1][1],
				a[1][2],
				a[2][2],
				a[2][1],
		};
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 4; i++) {
			int val = rotations(b, a[0][0], i)
					+ rotations(b, a[0][1], i)
					+ rotations(b, a[1][0], i)
					+ rotations(b, a[1][1], i);
			if (val < min) {
				min = val;
			}
		}
		out.println(min);
	}

	public static int rotations(int[] b, int x, int t) {
		int i = 0;
		while (b[i] != x) {
			i++;
		}
		int j = 0;
		while (b[(i + j) % b.length] != t) {
			j++;
		}
		return Math.min(j, b.length - j);
	}
}