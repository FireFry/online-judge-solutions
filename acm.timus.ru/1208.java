import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Problem1208 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1208() {
		this(System.in, System.out);
	}

	public Problem1208(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1208().run();
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
        int n = (int) readNumber();
        Set[] a = new Set[n];
        boolean[] b = new boolean[n];
        boolean[][] c = new boolean[n][n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new HashSet<String>(3);
            for (int k = 0; k < 3; k++) {
                String name = readWord();
                a[i].add(name);
                for (int j = 0; j < i; j++) {
                    if (a[j].contains(name)) {
                        c[i][j] = c[j][i] = true;
                    }
                }
            }
        }
        int maxCount = 0;
        int count = 0;
        for (;;) {
            int i = 0;
            while (i < b.length && b[i]) {
                b[i] = false;
                count--;
                i++;
            }
            if (i == b.length) {
                break;
            }
            b[i] = true;
            count++;
            boolean isBad = count <= maxCount;
            for (int j = i; !isBad && j < n; j++) {
                if (b[j]) {
                    for (int k = i; !isBad && k < n; k++) {
                        if (b[k]) {
                            isBad |= c[k][j];
                        }
                    }
                }
            }
            if (!isBad && count > maxCount) {
                maxCount = count;
            }
        }
        out.println(maxCount);
	}
}
