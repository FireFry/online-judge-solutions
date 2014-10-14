import java.io.*;
import java.util.Arrays;

public class Problem1586 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1586() {
		this(System.in, System.out);
	}

	public Problem1586(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1586().run();
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

    int[] a = {113,211,311,811,911,127,131,613,313,137,139,149,157,163,167,317,617,173,179,181,419,619,719,191,919,193,197,199,421,521,821,223,227,229,233,523,823,239,241,257,263,269,271,727,827,277,281,283,829,929,293,331,431,631,433,733,337,347,349,359,367,373,937,379,383,439,739,839,397,541,641,941,443,643,743,449,457,461,463,467,547,647,479,947,487,491,499,557,563,569,571,757,857,577,587,659,859,593,599,661,761,863,673,967,677,683,769,691,971,773,877,977,787,797,881,883,983,887,991,997,};
    boolean[][] b = new boolean[a.length][a.length];
    private static final int MOD = 1000000000 + 9;

	private void solve() throws Exception {
        int n = (int) readNumber();
        if (n == 3) {
            out.println(143);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                b[i][j] = a[i] % 100 == a[j] / 10;
            }
        }
        long[] c = new long[a.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = 1;
        }
        long[] d = new long[a.length];
        int k = 3;
        while (k < n) {
            for (int i = 0; i < d.length; i++) {
                d[i] = 0;
            }
            for (int i = 0; i < c.length; i++) {
                if (c[i] > 0) {
                    for (int j = 0; j < d.length; j++) {
                        if (b[i][j]) {
                            d[j] = (d[j] + c[i]) % MOD;
                        }
                    }
                }
            }
            /*swap*/ {
                long[] z = c;
                c = d;
                d = z;
            }
            k++;
        }
        long total = 0;
        for (int i = 0; i < c.length; i++) {
            total = (total + c[i]) % MOD;
        }
        out.println(total);
	}
}
