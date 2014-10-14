import java.io.*;

public class Problem1712 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1712() {
		this(System.in, System.out);
	}

	public Problem1712(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1712().run();
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

	private static final int[][] rotation = {
			{0, 1},
			{-1, 0},
	};

	private void solve() throws Exception {
		boolean[][] a = new boolean[4][4];
		boolean[][] c = new boolean[4][4];
		char[][] b = new char[4][4];

		for (int i = 0; i < a.length; i++) {
			String next = bufferedReader.readLine();
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = next.charAt(j) == 'X';
			}
		}
		for (int i = 0; i < b.length; i++) {
			String next = bufferedReader.readLine();
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = next.charAt(j);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int x = 0; x < a.length; x++) {
				for (int y = 0; y < a[x].length; y++) {
					if (a[x][y]) {
						sb.append(b[x][y]);
					}
					int rx = x * rotation[0][0] + y * rotation[0][1];
					int ry = x * rotation[1][0] + y * rotation[1][1] + 3;
					c[rx][ry] = a[x][y];
				}
			}
			if (i < 3) {
				boolean[][] temp = a;
				a = c;
				c = temp;
			}
		}
		out.println(sb);
	}
}