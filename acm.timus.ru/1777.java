import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1777 implements Runnable {
	private BufferedReader bufferedReader;
	private Scanner in;
	private PrintWriter out;

	public Problem1777() {
		this(System.in, System.out);
	}

	public Problem1777(InputStream inputStream, OutputStream outputStream) {
		in = new Scanner(inputStream);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1777().run();
	}

	public void run() {
		try {
			solve();
			out.flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private long readNumber() throws IOException {
		return in.nextLong();
	}

	//TODO global variables

	private void solve() throws Exception {
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < 3; i++) {
			list.add(readNumber());
		}
		int x = 0;
		while (true) {
			++x;
			long minDiff = Long.MAX_VALUE;
			for (int i = 1; i < list.size(); i++) {
				for (int j = 0; j < i; j++) {
					minDiff = Math.min(minDiff, Math.abs(list.get(i) - list.get(j)));
				}
			}
			if (minDiff == 0) {
				out.println(x);
				return;
			}
			list.add(minDiff);
		}
	}
}