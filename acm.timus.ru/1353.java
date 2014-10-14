import java.io.*;

public class Problem1353 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1353() {
		this(System.in, System.out);
	}

	public Problem1353(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1353().run();
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
	private static final int[] a = new int[]{
			10
			, 45
			, 165
			, 495
			, 1287
			, 3003
			, 6435
			, 12870
			, 24310
			, 43749
			, 75501
			, 125565
			, 202005
			, 315315
			, 478731
			, 708444
			, 1023660
			, 1446445
			, 2001285
			, 2714319
			, 3612231
			, 4720815
			, 6063255
			, 7658190
			, 9517662
			, 11645073
			, 14033305
			, 16663185
			, 19502505
			, 22505751
			, 25614639
			, 28759500
			, 31861500
			, 34835625
			, 37594305
			, 40051495
			, 42126975
			, 43750575
			, 44865975
			, 45433800
			, 45433800
			, 44865975
			, 43750575
			, 42126975
			, 40051495
			, 37594305
			, 34835625
			, 31861500
			, 28759500
			, 25614639
			, 22505751
			, 19502505
			, 16663185
			, 14033305
			, 11645073
			, 9517662
			, 7658190
			, 6063255
			, 4720815
			, 3612231
			, 2714319
			, 2001285
			, 1446445
			, 1023660
			, 708444
			, 478731
			, 315315
			, 202005
			, 125565
			, 75501
			, 43749
			, 24310
			, 12870
			, 6435
			, 3003
			, 1287
			, 495
			, 165
			, 45
			, 9
			, 1
			,};

	private void solve() throws Exception {
		out.println(a[(int) readNumber() - 1]);
	}
}