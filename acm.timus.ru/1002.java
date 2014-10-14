import java.io.*;

public class PhoneNumbersSecondTry implements Runnable {
	public static final String END_OF_INPUT = "-1";
	public static final int MAX_DICTIONARY_LENGTH = 50000;
	public static final char SYMBOL_TO_NUMBER[] = new char[] {
			'2',//a
			'2',//b
			'2',//c
			'3',//d
			'3',//e
			'3',//f
			'4',//g
			'4',//h
			'1',//i
			'1',//j
			'5',//k
			'5',//l
			'6',//m
			'6',//n
			'0',//o
			'7',//p
			'0',//q
			'7',//r
			'7',//s
			'8',//t
			'8',//u
			'8',//v
			'9',//w
			'9',//x
			'9',//y
			'0',//z
	};
	public static final String NO_SOLUTION = "No solution.";

	private BufferedReader in;
	private PrintWriter out;

	public PhoneNumbersSecondTry() {
		this(System.in, System.out);
	}

	public PhoneNumbersSecondTry(InputStream inputStream, OutputStream outputStream) {
		in = new BufferedReader(new InputStreamReader(inputStream));
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new PhoneNumbersSecondTry().run();
	}

	public void run() {
		try {
			solve();
			out.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private final String[] words = new String[MAX_DICTIONARY_LENGTH];
	private final String[] numbers = new String[MAX_DICTIONARY_LENGTH];
	private final int[] result = new int[100];
	private final int[] wordDynamic = new int[100];
	private final int[] amountDynamic = new int[100];
	private final StringBuffer stringBuffer = new StringBuffer();
	private String number;
	private int dictionarySize;
	private int heapSize;
	private String temp;

	private void solve() throws IOException {
		while (!(number = in.readLine()).equals(END_OF_INPUT)) {
			resetVariables();
			readTest();
			sort();
			search();
			printResult();
		}
	}

	private void resetVariables() {
		for (int i = 0; i < wordDynamic.length; i++) {
			wordDynamic[i] = -1;
			amountDynamic[i] = Integer.MAX_VALUE;
		}
		amountDynamic[0] = 0;
	}

	private void readTest() throws IOException {
		dictionarySize = Integer.parseInt(in.readLine());
		for (int i = 0; i < dictionarySize; ++i) {
			temp = in.readLine().toLowerCase();
			words[i] = temp;
			numbers[i] = parseNumber(temp);
		}
	}

	private String parseNumber(String word) {
		stringBuffer.setLength(0);
		for (int i = 0; i < word.length(); i++) {
			stringBuffer.append(SYMBOL_TO_NUMBER[word.charAt(i) - 'a']);
		}
		return stringBuffer.toString();
	}

	private void sort() {
		heapSize = dictionarySize;
		for (int i = (heapSize - 1) / 2; i >= 0; --i) {
			heapify(i);
		}
		while (heapSize > 1) {
			swap(0, heapSize - 1);
			--heapSize;
			heapify(0);
		}
	}

	private void heapify(int root) {
		int child = root << 1;
		if (child >= heapSize) {
			return;
		}
		int largest;
		if (numbers[child].compareTo(numbers[root]) > 0) {
			largest = child;
		} else {
			largest = root;
		}
		++child;
		if (child < heapSize && numbers[child].compareTo(numbers[largest]) > 0) {
			largest = child;
		}
		if (largest != root) {
			swap(root, largest);
			heapify(largest);
		}
	}

	private void swap(int i, int j) {
		temp = words[i];
		words[i] = words[j];
		words[j] = temp;
		temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	private void search() {
		for (int symbol = 1; symbol <= number.length(); ++symbol) {
			for (int from = Math.max(0, symbol - 50); from < symbol && amountDynamic[symbol] > 2; ++from) {
				int length = symbol - from;
				int word = find(from, length);
				if (word >= 0 && amountDynamic[symbol - length] < Integer.MAX_VALUE) {
					int newAmount = amountDynamic[symbol - length] + 1;
					if (amountDynamic[symbol] > newAmount) {
						wordDynamic[symbol] = word;
						amountDynamic[symbol] = newAmount;
					}
				}
			}
		}
	}

	private int find(int from, int length) {
		int lowerBound = 0;
		int upperBound = dictionarySize;
		while (lowerBound < upperBound) {
			int middle = (lowerBound - 1 + upperBound) / 2;
			int compare = compare(numbers[middle], number, from, length);
			if (compare == 0) {
				return middle;
			}
			if (compare > 0) {
				upperBound = middle;
			} else {
				lowerBound = middle + 1;
			}
		}
		return -1;
	}

	private int compare(String strA, String strB, int fromB, int lengthB) {
		int length = strA.length() < lengthB ? strA.length() : lengthB;
		for (byte i = 0; i < length; i++) {
			int comparation = strA.charAt(i) - strB.charAt(fromB + i);
			if (comparation != 0) {
				return comparation;
			}
		}
		return strA.length() - lengthB;
	}

	private void printResult() {
		if (amountDynamic[number.length()] == Integer.MAX_VALUE) {
			out.println(NO_SOLUTION);
		} else {
			int i = 0;
			int p = number.length();
			do {
				result[i++] = wordDynamic[p];
				p -= words[wordDynamic[p]].length();
			} while (p > 0);
			while (i > 0) {
				out.print(words[result[i - 1]]);
				--i;
				if (i > 0) {
					out.print(' ');
				} else {
					out.println();
				}
			}
		}
	}
}