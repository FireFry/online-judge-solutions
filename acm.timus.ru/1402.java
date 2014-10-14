import java.io.*;

public class Problem1402 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1402() {
		this(System.in, System.out);
	}

	public Problem1402(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1402().run();
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
		out.println(get((int) readNumber()));
	}

	private String get(int n) {
		switch (n) {
			case 2: return "2";
			case 3: return "12";
			case 4: return "60";
			case 5: return "320";
			case 6: return "1950";
			case 7: return "13692";
			case 8: return "109592";
			case 9: return "986400";
			case 10: return "9864090";
			case 11: return "108505100";
			case 12: return "1302061332";
			case 13: return "16926797472";
			case 14: return "236975164790";
			case 15: return "3554627472060";
			case 16: return "56874039553200";
			case 17: return "966858672404672";
			case 18: return "17403456103284402";
			case 19: return "330665665962403980";
			case 20: return "6613313319248079980";
			case 21: return "138879579704209680000";
		}
		return "0";
	}
}