import java.io.*;

public class Problem1260 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1260() {
		this(System.in, System.out);
	}

	public Problem1260(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1260().run();
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

	private int get(int x) {
		switch (x) {
			case 2:return 1;
			case 3:return 2;
			case 4:return 4;
			case 5:return 6;
			case 6:return 9;
			case 7:return 14;
			case 8:return 21;
			case 9:return 31;
			case 10:return 46;
			case 11:return 68;
			case 12:return 100;
			case 13:return 147;
			case 14:return 216;
			case 15:return 317;
			case 16:return 465;
			case 17:return 682;
			case 18:return 1000;
			case 19:return 1466;
			case 20:return 2149;
			case 21:return 3150;
			case 22:return 4617;
			case 23:return 6767;
			case 24:return 9918;
			case 25:return 14536;
			case 26:return 21304;
			case 27:return 31223;
			case 28:return 45760;
			case 29:return 67065;
			case 30:return 98289;
			case 31:return 144050;
			case 32:return 211116;
			case 33:return 309406;
			case 34:return 453457;
			case 35:return 664574;
			case 36:return 973981;
			case 37:return 1427439;
			case 38:return 2092014;
			case 39:return 3065996;
			case 40:return 4493436;
			case 41:return 6585451;
			case 42:return 9651448;
			case 43:return 14144885;
			case 44:return 20730337;
			case 45:return 30381786;
			case 46:return 44526672;
			case 47:return 65257010;
			case 48:return 95638797;
			case 49:return 140165470;
			case 50:return 205422481;
			case 51:return 301061279;
			case 52:return 441226750;
			case 53:return 646649232;
			case 54:return 947710512;
			case 55:return 1388937263;
		}
		return 1;
	}
}