import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Problem1795 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1795() {
		this(System.in, System.out);
	}

	public Problem1795(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1795().run();
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
		int m = (int) readNumber();
        Map<String, Integer> items = new HashMap<String, Integer>(m);
        int[] counts = new int[m];
        for (int i = 0; i < m; i++) {
            counts[i] = (int) readNumber();
            readWord();
            items.put(readWord(), i);
        }
        int n = (int) readNumber();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = (int) readNumber();
            readWord();
            Integer id = items.get(readWord());
            a[i][1] = id == null ? -1 : id;
        }
        int i = 0;
        int s = 0;
        while (i < n) {
            if (a[i][1] == -1) {
                i++;
            } else if (counts[a[i][1]] >= a[i][0]) {
                counts[a[i][1]] -= a[i][0];
                i++;
            } else if (i == n - 1 || counts[a[i][1]] == 0) {
                i++;
            } else {
                a[i][0] = counts[a[i][1]];
                int[] b= a[i];
                a[i] = a[i + 1];
                a[i + 1] = b;
            }
            s++;
        }
        out.println(s);
    }
}
