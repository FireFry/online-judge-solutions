import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Problem1680 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1680() {
		this(System.in, System.out);
	}

	public Problem1680(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1680().run();
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
        String[] firstLine = bufferedReader.readLine().split(" ");
        int m = Integer.valueOf(firstLine[2]);
        int j = 0;
        Set<String> keys = new HashSet<String>(m);
        while (j <= m) {
            String name = bufferedReader.readLine();
            String key = name.split(" #")[0];
            if (!keys.contains(key)) {
                if (j == m) {
                    out.println(name);
                    return;
                }
                keys.add(key);
                j++;
            }
        }
	}
}
