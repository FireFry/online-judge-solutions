import java.io.*;

public class CookingTheBooks {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

        for (int t = 1, ts = Integer.parseInt(in.readLine()); t <= ts; t++) {
            char[] s = in.readLine().toCharArray();

            out.print("Case #");
            out.print(t);
            out.print(":");

            for (int compareFactor = -1; compareFactor <= 1; compareFactor += 2) {
                int swapi = 0;
                int swapj = 0;
                for (int i = 0, si = s.length - 1; i < si; i++) {
                    int opt = i;
                    for (int j = s.length - 1; j > i; j--) {
                        if ((s[j] > '0' || i > 0) && Character.compare(s[j], s[opt]) * compareFactor > 0) {
                            opt = j;
                        }
                    }
                    if (opt > i) {
                        swapi = i;
                        swapj = opt;
                        break;
                    }
                }

                out.print(' ');
                printSwapped(out, s, swapi, swapj);
            }

            out.println();
        }

        out.flush();
    }

    private static void printSwapped(PrintWriter out, char[] s, int i, int j) {
        swap(s, i, j);
        for (char ch : s) {
            out.print(ch);
        }
        swap(s, i, j);
    }

    private static void swap(char[] s, int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }

}
