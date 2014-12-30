import java.io.*;

public class TestApp {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	void solve() throws Exception {
		int n = Integer.parseInt(in.readLine());

		char[] stack = new char[2 * n];
		int[] stackId = new int[2 * n];
		int[] g = new int[n];
		int stackSize = 0;
		int ghostsCount = 0;
		int ghostbustersCount = 0;

		for (int i = 0, size = 2 * n; i < size; i++) {
			char ch = (char) in.read();
			boolean match = false;
			int index = (ch < 'a') ? ghostsCount++ : ghostbustersCount++;

			if (stackSize > 0) {
				char head = stack[stackSize - 1];
				if (head + 'A' == ch + 'a') {
					match = true;
					g[index] = stackId[stackSize - 1];
				} else if (head + 'a' == ch + 'A') {
					match = true;
					g[stackId[stackSize - 1]] = index;
				}
			}

			if (match) {
				stackSize--;
			} else {
				stack[stackSize] = ch;
				stackId[stackSize] = index;
				stackSize++;
			}
		}

		if (stackSize == 0) {
			for (int i = 0; i < g.length; i++) {
				out.print(g[i] + 1);
				if (i == g.length - 1) {
					out.println();
				} else {
					out.print(' ');
				}
			}
		} else {
			out.println("Impossible");
		}
		out.flush();
	}

	public static void main(String[] args) throws Exception {
		new TestApp().solve();
	}
}
