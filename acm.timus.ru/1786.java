import java.io.*;

public class Problem1786 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1786() {
		this(System.in, System.out);
	}

	public Problem1786(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1786().run();
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
	private static final String SANDRO = "Sandro";

	private void solve() throws Exception {
		String s = bufferedReader.readLine();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= s.length() - SANDRO.length(); i++) {
			int price = getPrice(s, i);
			if (price < min) {
				min = price;
			}
		}
		out.println(min);
	}

	private int getPrice(String s, int start) {
		int price = 0;
		for (int i = 0; i < SANDRO.length(); i++) {
			char ch1 = s.charAt(start + i);
			char ch2 = SANDRO.charAt(i);
			if (Character.isUpperCase(ch1) != Character.isUpperCase(ch2)) {
				price += 5;
			}
			if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
				price += 5;
			}
		}
		return price;
	}
}