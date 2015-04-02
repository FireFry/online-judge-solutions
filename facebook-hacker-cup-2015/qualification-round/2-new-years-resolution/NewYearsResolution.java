import java.io.*;
import java.io.StreamTokenizer;

public class NewYearsResolution {

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

        int[][] a = new int[1050000][3];
        int size;
        int[] g = new int[3];
        int[] step = new int[3];

        for (int t = 1, ts = read(in); t <= ts; t++) {
            readArray(in, g);
            size = 1;
            for (int i = 0; i < a[0].length; i++) {
                a[0][i] = 0;
            }
            boolean found = false;
            for (int i = 0, n = read(in); i < n; i++) {
                readArray(in, step);
                if (found) {
                    continue;
                }
                for (int j = 0, js = size; !found && j < js; j++) {
                    boolean fine = true;
                    found = true;
                    for (int k = 0; fine && k < a[j].length; k++) {
                        a[size][k] = a[j][k] + step[k];
                        found &= (a[size][k] == g[k]);
                        fine = (a[size][k] <= g[k]);
                    }
                    if (fine) {
                        size++;
                    }
                }
            }
            out.print("Case #");
            out.print(t);
            out.print(": ");
            out.println(found ? "yes" : "no");
        }

        out.flush();
    }

    private static int read(StreamTokenizer in) throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private static void readArray(StreamTokenizer in, int[] dst) throws IOException {
        for (int i = 0; i < dst.length; i++) {
            dst[i] = read(in);
        }
    }

}
