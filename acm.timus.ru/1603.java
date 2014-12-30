import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class TestApp {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	char[][] a;
	boolean[][] b;

	int n;
	String[] d;
	boolean[] r;

	Integer[] c;
	int s;

	int[][] offsets = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	void solve() throws Exception {
		a = new char[6][6];
		b = new boolean[6][6];
		for (int i = 1; i <= 4; i++) {
			String s = in.readLine();
			for (int j = 1; j <= 4; j++) {
				a[i][j] = s.charAt(j - 1);
				b[i][j] = true;
			}
		}

		n = Integer.parseInt(in.readLine());
		d = new String[n];
		r = new boolean[n];
		c = new Integer[n];
		s = n;
		for (int i = 0; i < n; i++) {
			d[i] = in.readLine();
			c[i] = i;
		}
		Arrays.sort(c, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return d[o1].compareTo(d[o2]);
			}
		});

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
		        rec(i, j, 0, 0, s);
			}
		}

		for (int i = 0; i < n; i++) {
			out.print(d[i]);
			out.println(r[i] ? ": YES" : ": NO");
		}

		out.flush();
	}

	void rec(int i, int j, int ch, int left, int right) {
		if (!b[i][j] || left >= right) {
			return;
		}
		b[i][j] = false;

		left = cut(a[i][j], ch, left, right);
		right = cut((char) (a[i][j] + 1), ch, left, right);

		while (left < right && d[c[left]].length() == ch + 1) {
			r[c[left]] = true;
			remove(left);
			right--;
		}

		for (int[] offset : offsets) {
			int ss = s;
			rec(i + offset[0], j + offset[1], ch + 1, left, right);
			right -= ss - s;
		}

		b[i][j] = true;
	}

	int cut(char cc, int ch, int left, int right) {
		while (left < right) {
			int m = (left + right - 1) / 2;
			if (d[c[m]].charAt(ch) < cc) {
				left = m + 1;
			} else {
				right = m;
			}
		}
		return left;
	}

	void remove(int i) {
		for (int j = i + 1; j < s; j++) {
			c[j - 1] = c[j];
		}
		s--;
	}

	public static void main(String[] args) throws Exception {
		new TestApp().solve();
	}
}
