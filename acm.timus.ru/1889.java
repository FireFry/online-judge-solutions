import java.io.*;
import java.util.*;

public class Problem1889 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1889() {
		this(System.in, System.out);
	}

	public Problem1889(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1889().run();
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
        int n = Integer.valueOf(bufferedReader.readLine());
        Map<String, Integer> langs = new HashMap<String, Integer>();
        langs.put("unknown", 0);
        int[] a = new int[n];
        int next = 1;
        int lastRecognized = 0;
        for (int i = 0; i < n; i++) {
            String language = bufferedReader.readLine();
            int langId;
            if (langs.containsKey(language)) {
                langId = langs.get(language);
                if (lastRecognized > 0 && langId > 0 && langId != lastRecognized) {
                    out.println("Igor is wrong.");
                    return;
                }
            } else {
                langId = next++;
                langs.put(language, langId);
            }
            a[i] = langId;
            if (langId > 0) {
                lastRecognized = langId;
            }
        }
        langs = null;

        boolean[] b = new boolean[next];
        int count = 0;
        for (int i = n; i >= 1; i--) {
            if (n % i == 0) {
                Arrays.fill(b, false);
                int currentSegment = 0;
                boolean hasFailed = false;
                for (int j = 0; !hasFailed && j < n; j++) {
                    if (j % i == 0) {
                        currentSegment = 0;
                    }
                    if (a[j] > 0) {
                        if (currentSegment == 0) {
                            if (b[a[j]]) {
                                hasFailed = true;
                            } else {
                                currentSegment = a[j];
                                b[currentSegment] = true;
                            }
                        } else if (currentSegment != a[j]) {
                            hasFailed = true;
                        }
                    }
                }
                if (!hasFailed) {
                    if (count > 0) {
                        out.print(' ');
                    }
                    out.print(n / i);
                    count++;
                }
            }
        }
        out.println();
	}
}
