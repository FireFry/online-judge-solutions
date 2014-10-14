import java.io.*;

public class Problem1079 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1079() {
		this(System.in, System.out);
	}

	public Problem1079(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1079().run();
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

	private static final int[] numbers = new int[] {
			0,
			1,
			3,
			5,
			9,
			11,
			19,
			21,
			35,
			37,
			43,
			69,
			73,
			75,
			83,
			85,
			139,
			147,
			149,
			165,
			171,
			277,
			293,
			299,
			331,
			339,
			341,
			555,
			587,
			595,
			597,
			661,
			683,
			1109,
			1173,
			1189,
			1195,
			1323,
			1355,
			1363,
			1365,
			2219,
			2347,
			2379,
			2387,
			2389,
			2645,
			2709,
			2731,
			4437,
			4691,
			4693,
			4757,
			4779,
			5291,
			5419,
			5451,
			5459,
			5461,
			8875,
			9387,
			9515,
			9547,
			9555,
			9557,
			10581,
			10837,
			10923,
			17749,
			18771,
			18773,
			19029,
			19093,
			19115,
			21163,
			21675,
			21803,
			21835,
			21843,
			21845,
			35499,
			37547,
			38059,
			38187,
			38219,
			38227,
			38229,
			42325,
			43349,
			43605,
			43691,
			70997,
			75091,
			75093,
			76117,
			76373,
			76459,
			84651,
			86699,
			87211,
			87339,
			87371,
			87379,
			87381,
	};
	private static final int[] values = new int[] {
			0,
			1,
			2,
			3,
			4,
			5,
			7,
			8,
			9,
			11,
			13,
			14,
			15,
			18,
			19,
			21,
			23,
			26,
			29,
			30,
			34,
			37,
			41,
			47,
			49,
			50,
			55,
			60,
			67,
			69,
			76,
			79,
			89,
			97,
			108,
			109,
			123,
			128,
			129,
			131,
			144,
			157,
			175,
			178,
			181,
			199,
			207,
			208,
			233,
			254,
			257,
			283,
			287,
			322,
			335,
			337,
			338,
			343,
			377,
			411,
			458,
			465,
			467,
			474,
			521,
			542,
			545,
			610,
			665,
			674,
			741,
			752,
			753,
			843,
			877,
			882,
			883,
			885,
			898,
			987,
			1076,
			1199,
			1217,
			1220,
			1223,
			1241,
			1364,
			1419,
			1427,
			1428,
			1597,
			1741,
			1765,
			1940,
			1969,
			1973,
			2207,
			2296,
			2309,
			2311,
			2312,
			2317,
			2351,
			2584,
	};


	private void solve() throws Exception {
		int n;
		while ((n = (int) readNumber()) != 0) {
			int i = 0;
			while (i < numbers.length - 1 && numbers[i + 1] <= n) {
				i++;
			}
			out.println(values[i]);
		}
	}
}