import java.io.*;

public class Problem1225 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1225() {
		this(System.in, System.out);
	}

	public Problem1225(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1225().run();
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

	private static final long[] answers = new long[] {
			2L,
			2L,
			4L,
			6L,
			10L,
			16L,
			26L,
			42L,
			68L,
			110L,
			178L,
			288L,
			466L,
			754L,
			1220L,
			1974L,
			3194L,
			5168L,
			8362L,
			13530L,
			21892L,
			35422L,
			57314L,
			92736L,
			150050L,
			242786L,
			392836L,
			635622L,
			1028458L,
			1664080L,
			2692538L,
			4356618L,
			7049156L,
			11405774L,
			18454930L,
			29860704L,
			48315634L,
			78176338L,
			126491972L,
			204668310L,
			331160282L,
			535828592L,
			866988874L,
			1402817466L,
			2269806340L,
	};

	private void solve() throws Exception {
		out.println(answers[(int) readNumber() - 1]);
	}
}