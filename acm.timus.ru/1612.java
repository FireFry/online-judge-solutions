import java.io.*;

public class Problem1612 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1612() {
		this(System.in, System.out);
	}

	public Problem1612(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1612().run();
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
	private static final int STATE_NO_WORD = 0;
	private static final int STATE_UNK_WORD = 1;
	private static final int STATE_T = 2;
	private static final int STATE_TR = 3;
	private static final int STATE_TRA = 4;
	private static final int STATE_TRAM = 5;
	private static final int STATE_TRO = 6;
	private static final int STATE_TROL = 7;
	private static final int STATE_TROLL = 8;
	private static final int STATE_TROLLE = 9;
	private static final int STATE_TROLLEY = 10;
	private static final int STATE_TROLLEYB = 11;
	private static final int STATE_TROLLEYBU = 12;
	private static final int STATE_TROLLEYBUS = 13;

	private static final class Rule {
		public final int state;
		public final char ch;
		public final int next;

		private Rule(int state, char ch, int next) {
			this.state = state;
			this.ch = ch;
			this.next = next;
		}
	}

	private static final Rule[] rules = new Rule[] {
			new Rule(STATE_NO_WORD, 't', STATE_T),
			new Rule(STATE_T, 'r', STATE_TR),
			new Rule(STATE_TR, 'a', STATE_TRA),
			new Rule(STATE_TRA, 'm', STATE_TRAM),
			new Rule(STATE_TR, 'o', STATE_TRO),
			new Rule(STATE_TRO, 'l', STATE_TROL),
			new Rule(STATE_TROL, 'l', STATE_TROLL),
			new Rule(STATE_TROLL, 'e', STATE_TROLLE),
			new Rule(STATE_TROLLE, 'y', STATE_TROLLEY),
			new Rule(STATE_TROLLEY, 'b', STATE_TROLLEYB),
			new Rule(STATE_TROLLEYB, 'u', STATE_TROLLEYBU),
			new Rule(STATE_TROLLEYBU, 's', STATE_TROLLEYBUS),
	};

	private void solve() throws Exception {
		int next;
		int state = STATE_NO_WORD;
		int tramCount = 0;
		int trolleybusCount = 0;
		while ((next = bufferedReader.read()) != -1) {
			char ch = (char) next;
			boolean isLetter = ch >= 'a' && ch <= 'z';
			if (!isLetter) {
				if (state == STATE_TRAM) {
					tramCount++;
				} else if (state == STATE_TROLLEYBUS) {
					trolleybusCount++;
				}
				state = STATE_NO_WORD;
			} else {
				int i = 0;
				while (i < rules.length && (rules[i].state != state || rules[i].ch != ch)) {
					i++;
				}
				if (i < rules.length) {
					state = rules[i].next;
				} else {
					state = STATE_UNK_WORD;
				}
			}
		}
		if (tramCount > trolleybusCount) {
			out.println("Tram driver");
		} else if (tramCount < trolleybusCount) {
			out.println("Trolleybus driver");
		} else {
			out.println("Bus driver");
		}
	}
}