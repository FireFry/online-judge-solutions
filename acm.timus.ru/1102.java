import java.io.*;

public class Problem1102 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1102() {
		this(System.in, System.out);
	}

	public Problem1102(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1102().run();
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
    String[] words = new String[] {
            "puton",
            "inputone",
            "outputone",
            "one",
    };

    boolean[][] maps = new boolean[][] {
            {false, false, false, false, true},
            {false, true, false, false, true, false, true, true},
            {false, false, true, false, false, true, false, true, true},
            {false, false, true},
    };

	private void solve() throws Exception {
        int n = Integer.valueOf(bufferedReader.readLine());
        int word = -1;
        int symbol = -1;
        boolean wasStarted = false;
        boolean isFailed = false;
        int next;
        while ((next = bufferedReader.read()) != -1) {
            char ch = (char) next;
            if (ch == '\n') {
                if (word >= 0 && !maps[word][symbol]) {
                    isFailed = true;
                }
                out.println(isFailed ? "NO" : "YES");
                word = -1;
                symbol = -1;
                isFailed = false;
                wasStarted = false;
            }
            if (isFailed || ch < 'a' || ch > 'z') {
                continue;
            }
            if (word == -1) {
                int i = 0;
                while (i < words.length && words[i].charAt(0) != ch) {
                    i++;
                }
                if (i < words.length) {
                    word = i;
                    symbol = 0;
                    wasStarted = true;
                } else {
                    isFailed = true;
                    continue;
                }
            } else {
                if (word == 2 && symbol == 0 && ch == 'n') {
                    word = 3;
                }
                if ((word == 1 && symbol == 5 || word == 2 && symbol == 6) && ch == 'u') {
                    word = 2;
                    symbol = 0;
                }
                if (words[word].charAt(symbol + 1) != ch) {
                    if (!maps[word][symbol]) {
                        isFailed = true;
                        continue;
                    }
                    int i = 0;
                    while (i < words.length && words[i].charAt(0) != ch) {
                        i++;
                    }
                    if (i < words.length) {
                        word = i;
                        symbol = 0;
                        wasStarted = true;
                    } else {
                        isFailed = true;
                        continue;
                    }
                } else {
                    symbol++;
                    if (symbol == words[word].length() - 1) {
                        word = -1;
                        symbol = -1;
                    }
                }
            }
        }
        if (wasStarted) {
            if (word >= 0 && !maps[word][symbol]) {
                isFailed = true;
            }
            out.println(isFailed ? "NO" : "YES");
        }
	}
}
