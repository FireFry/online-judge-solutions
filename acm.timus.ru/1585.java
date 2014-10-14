import java.io.*;

public class Problem1585 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1585() {
		this(System.in, System.out);
	}

	public Problem1585(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1585().run();
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

	private static final String[] penguins = {
			"Emperor Penguin",
			"Macaroni Penguin",
			"Little Penguin"
	};

	private void solve() throws Exception {
		int count = Integer.parseInt(bufferedReader.readLine());
		int[] counts = new int[] {0, 0, 0};
		for (int i = 0; i < count; i++) {
			char first = bufferedReader.readLine().charAt(0);
			int j = 0;
			while (penguins[j].charAt(0) != first) {
				j++;
			}
			++counts[j];
		}
		int max = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > counts[max]) {
				max = i;
			}
		}
		out.println(penguins[max]);
	}
}