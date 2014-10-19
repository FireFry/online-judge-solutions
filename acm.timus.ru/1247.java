import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Solution {
	StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}

	private void solve() throws IOException {
		out.println(correct() ? "YES" : "NO");
		out.flush();
	}

	private boolean correct() throws IOException {
		int s = readInt();
		int n = readInt();

		int[] a = new int[s];
		int sum = 0;
		for (int i = 0; i < s; i++) {
			int v = readInt() - 1;
			a[i] = v;
			sum += v;
			if (sum < 0) {
				return false;
			}
		}

		sum = 0;
		for (int i = s - 1; i >= 0; i--) {
			sum += a[i];
			if (sum < 0) {
				return false;
			}
		}

		return true;
	}

	private int readInt() throws IOException {
		in.nextToken();
		return (int) in.nval;
	}
}
