import java.io.*;
import java.util.Locale;

public class Problem1413 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1413() {
		this(System.in, System.out);
	}

	public Problem1413(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1413().run();
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
        int x = 0;
        int x2 = 0;
        int y = 0;
        int y2 = 0;
        int next;
        while ((next = bufferedReader.read()) != -1 && next != '0') {
            switch (next) {
                case '1':
                    x2--;
                    y2--;
                    break;
                case '2':
                    y--;
                    break;
                case '3':
                    x2++;
                    y2--;
                    break;
                case '4':
                    x--;
                    break;
                case '6':
                    x++;
                    break;
                case '7':
                    x2--;
                    y2++;
                    break;
                case '8':
                    y++;
                    break;
                case '9':
                    x2++;
                    y2++;
                    break;
            }
        }
        out.format(Locale.US, "%.10f", x + x2 * Math.sqrt(2) / 2);
        out.print(' ');
        out.format(Locale.US, "%.10f", y + y2 * Math.sqrt(2) / 2);
        out.println();
	}
}
