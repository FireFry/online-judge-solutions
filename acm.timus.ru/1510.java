public class Problem1510 {
	public static void main(String[] args) throws Exception {
		int n = 0;
		int next;
		while ((next = System.in.read() - '0') >= 0 && next <= 9) {
			n = n * 10 + next;
		}
		int a = -1;
		int b = 0;
		int y = n;
		for (int i = 0; i < n && i < y; i++) {
			while ((next = System.in.read() - '0') < 0 || next > 9) ;
			int x = next;
			while ((next = System.in.read() - '0') >= 0 && next <= 9) {
				x = x * 10 + next;
			}
			if (b == 0) {
				a = x;
				b = 1;
			} else if (a == x) {
				++b;
			} else {
				--b;
			}
			y = n - b;
		}
		System.out.println(a);
		System.out.flush();
	}
}