import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Problem1191 {

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int cop = readInt(in);
        int n = readInt(in);
        for (int i = 0; i < n; i++) {
            int k = readInt(in);
            if (cop < k) {
                out.println("YES");
                out.flush();
                return;
            }
            cop -= cop % k;
        }
        out.println("NO");
        out.flush();
    }

    private static int readInt(StreamTokenizer in) throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

}
