import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Problem1779 {

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(in.readLine());
        int j = 0;
        int i1 = (n - 1) / 2;
        int i = i1 - 1;
        out.println((i + 1) * (i + 2) / 2);
        while (i >= j) {
            out.print(i + 1);
            out.print(' ');
            out.println(n - i);
            for (int k = j; k < i; k++) {
                out.print(i + 1);
                out.print(' ');
                out.println(k + 1);
                out.print(n - i);
                out.print(' ');
                out.println(n - k);
            }
            --i;
            ++j;
        }
        out.flush();
    }


}
