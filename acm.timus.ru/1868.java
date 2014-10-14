import java.io.*;

public class Problem1868 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1868() {
		this(System.in, System.out);
	}

	public Problem1868(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1868().run();
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
	public static final String DIVIDOR = " : ";
	public static final String[] MEDALS = {
			"gold",
			"silver",
			"bronze"
	};

	private void solve() throws Exception {
		String[] a = new String[12];
		for (int i = 0; i < a.length; i++) {
			a[i] = bufferedReader.readLine();
		}
		int n = Integer.parseInt(bufferedReader.readLine());
		int max = 0;
		int totalMoney = 0;
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(bufferedReader.readLine());
			int c = 0;
			for (int j = 0; j < k; j++) {
				String s = bufferedReader.readLine();
				int x = s.indexOf(DIVIDOR);
				String name = s.substring(0, x);
				String medal = s.substring(x + DIVIDOR.length());
                int medalId = 0;
				while (!MEDALS[medalId].equals(medal)) {
					medalId++;
				}
				boolean isCorrect = false;
				int m = a.length / MEDALS.length;
				for (int l = 0; l < m && !isCorrect; l++) {
					isCorrect |= a[medalId * m + l].equals(name);
				}
				if (isCorrect) {
					c++;
				}
			}
			if (c == max) {
				totalMoney += 5;
			} else if (c > max) {
				max = c;
				totalMoney = 5;
			}
		}
		out.println(totalMoney);
	}
}