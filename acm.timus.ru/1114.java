import java.io.*;
import java.math.BigInteger;

public class Problem1114 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1114() {
		this(System.in, System.out);
	}

	public Problem1114(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1114().run();
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
    long[][] f = new long[][] {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
            {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,},
            {1,3,6,10,15,21,28,36,45,55,66,78,91,105,120,136,},
            {1,4,10,20,35,56,84,120,165,220,286,364,455,560,680,816,},
            {1,5,15,35,70,126,210,330,495,715,1001,1365,1820,2380,3060,3876,},
            {1,6,21,56,126,252,462,792,1287,2002,3003,4368,6188,8568,11628,15504,},
            {1,7,28,84,210,462,924,1716,3003,5005,8008,12376,18564,27132,38760,54264,},
            {1,8,36,120,330,792,1716,3432,6435,11440,19448,31824,50388,77520,116280,170544,},
            {1,9,45,165,495,1287,3003,6435,12870,24310,43758,75582,125970,203490,319770,490314,},
            {1,10,55,220,715,2002,5005,11440,24310,48620,92378,167960,293930,497420,817190,1307504,},
            {1,11,66,286,1001,3003,8008,19448,43758,92378,184756,352716,646646,1144066,1961256,3268760,},
            {1,12,78,364,1365,4368,12376,31824,75582,167960,352716,705432,1352078,2496144,4457400,7726160,},
            {1,13,91,455,1820,6188,18564,50388,125970,293930,646646,1352078,2704156,5200300,9657700,17383860,},
            {1,14,105,560,2380,8568,27132,77520,203490,497420,1144066,2496144,5200300,10400600,20058300,37442160,},
            {1,15,120,680,3060,11628,38760,116280,319770,817190,1961256,4457400,9657700,20058300,40116600,77558760,},
            {1,16,136,816,3876,15504,54264,170544,490314,1307504,3268760,7726160,17383860,37442160,77558760,155117520,},
            {1,17,153,969,4845,20349,74613,245157,735471,2042975,5311735,13037895,30421755,67863915,145422675,300540195,},
            {1,18,171,1140,5985,26334,100947,346104,1081575,3124550,8436285,21474180,51895935,119759850,265182525,565722720,},
            {1,19,190,1330,7315,33649,134596,480700,1562275,4686825,13123110,34597290,86493225,206253075,471435600,1037158320,},
            {1,20,210,1540,8855,42504,177100,657800,2220075,6906900,20030010,54627300,141120525,347373600,818809200,1855967520,},
            {1,21,231,1771,10626,53130,230230,888030,3108105,10015005,30045015,84672315,225792840,573166440,1391975640,3247943160L,},
    };

	private void solve() throws Exception {
        int n = (int) readNumber();
        int a = (int) readNumber();
        int b = (int) readNumber();
        out.println(BigInteger.valueOf(f[n][a]).multiply(BigInteger.valueOf(f[n][b])));
	}
}
