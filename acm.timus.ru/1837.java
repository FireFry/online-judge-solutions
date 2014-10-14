import java.io.*;

public class Problem1837 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1837() {
		this(System.in, System.out);
	}

	public Problem1837(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1837().run();
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
	private int n;
	private int m;
	private String[] names;
	private int[] numbers;
	private boolean[][] connections;
	private int isenbaevIndex = -1;

	private void solve() throws Exception {
		n = (int) readNumber();
		m = 0;
		names = new String[n * 3];
		numbers = new int[names.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.MAX_VALUE;
		}
		connections = new boolean[names.length][names.length];

		int[] next = new int[3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < next.length; j++) {
				next[j] = getId(readWord());
				for (int k = 0; k < j; k++) {
					connections[next[k]][next[j]] = true;
					connections[next[j]][next[k]] = true;
				}
			}
		}

		if (isenbaevIndex >= 0) {
			numbers[isenbaevIndex] = 0;
			dfs(isenbaevIndex);
		}

		for (int i = 1; i < m; i++) {
			String key = names[i];
			int number = numbers[i];
			int j;
			for (j = i - 1; j >= 0 && names[j].compareTo(key) > 0; j--) {
				names[j + 1] = names[j];
				numbers[j + 1] = numbers[j];
			}
			names[j + 1] = key;
			numbers[j + 1] = number;
		}

		for (int i = 0; i < m; i++) {
			out.print(names[i]);
			out.print(' ');
			if (numbers[i] == Integer.MAX_VALUE) {
				out.println("undefined");
			} else {
				out.println(numbers[i]);
			}

		}
	}

	private int getId(String name) {
		for (int i = 0; i < m; i++) {
			if (names[i].equals(name)) {
				return i;
			}
		}
		names[m] = name;
		if (isenbaevIndex == -1 && name.equals("Isenbaev")) {
			isenbaevIndex = m;
		}
		return m++;
	}

	private void dfs(int index) {
		for (int i = 0; i < m; i++) {
			if (connections[index][i] && numbers[i] > numbers[index] + 1) {
				numbers[i] = numbers[index] + 1;
				dfs(i);
			}
		}
	}
}