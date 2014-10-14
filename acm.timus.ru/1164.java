import java.io.*;

public class Problem1164 implements Runnable {
    private BufferedReader bufferedReader;
    private StreamTokenizer in;
    private PrintWriter out;

    public Problem1164() {
        this(System.in, System.out);
    }

    public Problem1164(InputStream inputStream, OutputStream outputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        in = new StreamTokenizer(bufferedReader);
        out = new PrintWriter(new OutputStreamWriter(outputStream));
    }

    public static void main(String[] args) throws IOException {
        new Problem1164().run();
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
        int n = (int) readNumber();
        int m = (int) readNumber();
        int p = (int) readNumber();
        bufferedReader.readLine();
        char[] a = new char[n*m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < line.length(); j++) {
                a[k++] = line.charAt(j);
            }
        }
        for (int i = 0; i < p; i++) {
            String line = bufferedReader.readLine();
            for (int q = 0; q < line.length(); q++) {
                for (int j = 0; j < k; j++) {
                    if (a[j] == line.charAt(q)) {
                        k--;
                        a[j] = a[k];
                        break;
                    }
                }
            }
        }
        for (int i = 1; i < k; i++) {
            char key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        for (int i = 0; i < k; i++) {
            out.print(a[i]);
        }
        out.println();
    }
}