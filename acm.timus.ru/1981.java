import java.io.*;
import java.io.StreamTokenizer;

public class JavaSolution {
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        int n = readInt();
        switch (n) {
            case 4:
                out.println("0 2");
                break;
            case 5:
                out.println("0 0");
                break;
            case 6:
                out.println("6 9");
                break;
            default:
                long all = n * (n - 3L) / 2;
                out.print(all);
                out.print(' ');
                out.print(n % 2 == 0 ? all : 0);
        }
        out.close();
    }

    private static int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}
