import java.io.*;

public class Problem1126 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1126() {
		this(System.in, System.out);
	}

	public Problem1126(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1126().run();
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
		int m = (int) readNumber();
		int[] a = new int[25000];
		int n = 0;
		int x;
		while ((x = (int) readNumber()) != -1) {
			a[n++] = x;
		}
		int[][] sdt = new int[(int) Math.ceil(Math.log(a.length) / Math.log(2))][];
		int p = 1;
		int i = 0;
		while (p <= n) {
			sdt[i] = new int[n - p + 1];
			for (int j = 0; j < sdt[i].length; j++) {
				sdt[i][j] = (i == 0) ? a[j] : Math.max(sdt[i - 1][j], sdt[i - 1][j + p / 2]);
			}
			i++;
			p *= 2;
		}
		int k = (int) (Math.log(m) / Math.log(2));
		p = 1;
		int l = 0;
		while (k > 0) {
			p *= 2;
			l++;
			k--;
		}
		for (i = 0; i <= n - m; i++) {
			out.println(Math.max(sdt[l][i], sdt[l][i + m - p]));
		}
	}
}