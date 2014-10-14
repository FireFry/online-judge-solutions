import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		Map<Integer, Integer> added = new HashMap<Integer, Integer>(100000);
		Map<Integer, Integer> pos = new HashMap<Integer, Integer>(100000);
		int[] a = new int[262144];
		int offset = 131072;
		int size = 0;
		for (int n = readInt(); n > 0; n--) {
			char s = readSymbol();
			int value = readInt();
			if (s == '+') {
				Integer count = added.get(value);
				if (count == null) {
					a[offset + size] = value;
					recalc(a, (offset + size - 1) / 2);
					added.put(value, 1);
					pos.put(value, size);
					size++;
				} else {
					added.put(value, count + 1);
				}
			} else {
				Integer count = added.get(value);
				if (count > 1) {
					added.put(value, count - 1);
				} else {
					int i = pos.get(value);
					a[offset + i] = 0;
					recalc(a, (offset + i - 1) / 2);
					added.remove(value);
					pos.remove(value);
				}
			}
			out.println(Math.max(1, a[0]));
		}
		out.close();
	}

	private static void recalc(int[] a, int i) {
		while (i >= 0) {
			a[i] = gcd(a[2 * i + 1], a[2 * i + 2]);
			i = (i == 0) ? -1 : (i - 1) / 2;
		}
	}

	private static int gcd(int a, int b) {
		if (a > b) return gcd(b, a);
		if (a == 0) return b;
		return gcd(b % a, a);
	}

	private static char readSymbol() throws IOException {
		char result = (char) in.read();
		in.read();
		return result;
	}

	private static int readInt() throws IOException {
		return Integer.valueOf(in.readLine());
	}
}
