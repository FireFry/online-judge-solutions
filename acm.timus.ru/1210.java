import java.io.*;

public class Problem1210 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1210() {
		this(System.in, System.out);
	}

	public Problem1210(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1210().run();
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
		if (nextToken == StreamTokenizer.TT_WORD || nextToken > 0) {
			return in.sval;
		}
		throw new IllegalStateException("Word expected. Found: " + nextToken);
	}

	//TODO global variables

	private void solve() throws Exception {
        int n = (int) readNumber();
        int[] a = new int[30];
        int[] b = new int[30];
        int minBj = 0;
        for (int i = 0; i < n; i++) {
            int[] z = a;
            a = b;
            b = z;
            int k = (int) readNumber();
            minBj = 0;
            for (int j = 0; j < k; j++) {
                b[j] = 100000;
                int planet = (int) readNumber();
                while (planet > 0) {
                    int pay = (int) readNumber();
                    b[j] = Math.min(b[j], a[planet - 1] + pay);
                    if (b[j] < b[minBj]) {
                        minBj = j;
                    }
                    planet = (int) readNumber();
                }
            }
            if (i < n - 1) {
                readWord();
            }
        }
        out.println(b[minBj]);
	}
}
