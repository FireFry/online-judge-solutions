import java.io.*;

public class Localization implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Localization() {
		this(System.in, System.out);
	}

	public Localization(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Localization().run();
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

	private static final Rule[] rules = new Rule[] {
			new Rule(1, 4, "few"),
			new Rule(5, 9, "several"),
			new Rule(10, 19, "pack"),
			new Rule(20, 49, "lots"),
			new Rule(50, 99, "horde"),
			new Rule(100, 249, "throng"),
			new Rule(250, 499, "swarm"),
			new Rule(500, 999, "zounds"),
			new Rule(1000, 2000, "legion"),
	};

	private static final class Rule {
		public final int start;
		public final int end;
		public final String word;

		private Rule(int start, int end, String word) {
			this.start = start;
			this.end = end;
			this.word = word;
		}
	}

	private void solve() throws Exception {
		int n = (int) readNumber();
		for (int i = 0; i < rules.length; i++) {
			Rule rule = rules[i];
			if (n >= rule.start && n <= rule.end) {
				out.println(rule.word);
				return;
			}
		}
	}
}