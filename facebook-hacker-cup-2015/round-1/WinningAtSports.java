import java.io.*;

public class WinningAtSports {
    static BufferedReader in;
    static PrintWriter out;

    static int[][] foo = new int[2001][2001];
    static int[][] bar = new int[2001][2001];

    void solve() throws Exception {
        String[] line = in.readLine().split("-");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        out.print(foo[x][y]);
        out.print(' ');
        out.println(bar[y][y]);
    }

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new FileReader("input.txt"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        for (int t = 1, ts = Integer.parseInt(in.readLine()); t <= ts; t++) {
            out.print("Case #");
            out.print(t);
            out.print(": ");

            for (int x = 1; x < 2001; x++) {
                foo[x][0] = 1;
            }
            for (int y = 1; y < 2001; y++) {
                for (int x = y + 1; x < 2001; x++) {
                    foo[x][y] = (foo[x - 1][y] + foo[x][y - 1]) % 1000000007;
                }
            }

            bar[0][0] = 1;
            for (int y = 1; y < 2001; y++) {
                bar[0][y] = 1;
                for (int x = 1; x <= y; x++) {
                    bar[x][y] = (bar[x - 1][y] + bar[x][y - 1]) % 1000000007;
                }
            }

            new WinningAtSports().solve();
        }
        out.flush();
    }
}