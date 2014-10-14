import java.io.*;

public class Problem1821 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1821() {
		this(System.in, System.out);
	}

	public Problem1821(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1821().run();
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
		int n = Integer.parseInt(bufferedReader.readLine());
		String[] a = new String[n];
		String[] names = new String[n];
		int[] times = new int[n];
		int[] durations = new int[n];
		int size = 0;
		int minTime = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			String line = bufferedReader.readLine();
			String[] split = line.split("( |\\:|\\.)");
			String name = split[0];
			int time = (Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]) + i * 30) * 10 + Integer.parseInt(split[3]);
			int j = i - 1;
			while (j >= 0 && times[j] > time) {
				names[j + 1] = names[j];
				times[j + 1] = times[j];
				durations[j + 1] = durations[j];
				j--;
			}
			names[j + 1] = name;
			times[j + 1] = time;
			durations[j + 1] = time - 300 * i;
		}
		for (int i = 0; i < n; i++) {
			int time = durations[i];
			if (time < minTime) {
				minTime = time;
				int j = size - 1;
				while (j >= 0 && a[j].compareTo(names[i]) > 0) {
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1] = names[i];
				size++;
			}
		}
		out.println(size);
		for (int i = 0; i < size; i++) {
			out.println(a[i]);
		}
	}
}