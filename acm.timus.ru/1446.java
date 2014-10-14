import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Problem1446 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1446() {
		this(System.in, System.out);
	}

	public Problem1446(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1446().run();
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
	private static final String[] FACS = new String[]{
			"Slytherin",
			"Hufflepuff",
			"Gryffindor",
			"Ravenclaw",
	};

	private void solve() throws Exception {
		HashMap<String, List<String>> lists = new HashMap<String, List<String>>(FACS.length);
		for (int i = 0; i < FACS.length; i++) {
			lists.put(FACS[i], new LinkedList());
		}
		int n = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			String name = bufferedReader.readLine();
			String fac = bufferedReader.readLine();
			lists.get(fac).add(name);
		}
		for (int i = 0; i < FACS.length; i++) {
			out.print(FACS[i]);
			out.println(':');
			for (String each : lists.get(FACS[i])) {
				out.println(each);
			}
			if (i < FACS.length - 1) {
				out.println();
			}
		}
	}
}