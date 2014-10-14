import java.io.*;

public class JavaSolution {
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String line = in.readLine();
        int[] a1 = findAll(new int[2], line, '(');
        int[] a2 = findAll(new int[2], line, ')');
        int[] b1 = findAll(new int[2], line, '[');
        int[] b2 = findAll(new int[2], line, ']');
        int[] c1 = findAll(new int[2], line, '{');
        int[] c2 = findAll(new int[2], line, '}');
        int[] d = findAll(new int[1], line, ',');
        int i = 0;
        while (i < a1.length && a1[i] >= 0) {
            StringBuilder first = new StringBuilder(line.substring(c1[i] + 1, c2[i]).toLowerCase());
            String secont = line.substring(a1[i] + 1, a2[i]).toLowerCase();
            String third = line.substring(b1[i] + 1, b2[i]).toLowerCase();
            if (i == 0) {
                first.setCharAt(0, Character.toUpperCase(first.charAt(0)));
            } else {
                int j = d[i - 1];
                char ch;
                while ((ch = line.charAt(j++)) != '(' && ch != '{' && ch != '[') {
                    out.print(ch);
                }
            }
            out.print(first);
            out.print(' ');
            out.print(secont);
            out.print(' ');
            out.print(third);
            i++;
        }
        out.println();
        out.close();
    }

    private static int[] findAll(int[] result, String line, char ch) {
        int i = -1;
        int j = 0;
        while ((i = line.indexOf(ch, i + 1)) >= 0) {
            result[j++] = i;
        }
        while (j < result.length) {
            result[j++] = -1;
        }
        return result;
    }
}
