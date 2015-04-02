import java.io.*;

public class Autocomplete {
    private final BufferedReader in;
    private final PrintWriter out;

    Node root = new Node();

    public Autocomplete(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    void solve() throws Exception {
        int s = 0;
        for (int i = 0, n = Integer.parseInt(in.readLine()); i < n; i++) {
            char[] word = in.readLine().toCharArray();
            s += Math.max(add(root, word, 0), 1);
        }
        out.println(s);
    }

    int add(Node parent, char[] word, int offset) throws Exception {
        if (offset == word.length) {
            return offset;
        }
        int childIndex = word[offset] - 'a';
        Node node = parent.childs[childIndex];
        if (node != null) {
            return add(node, word, offset + 1);
        }
        node = parent.childs[childIndex] = new Node();
        add(node, word, offset + 1);
        return offset + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        for (int t = 1, ts = Integer.parseInt(in.readLine()); t <= ts; t++) {
            out.print("Case #");
            out.print(t);
            out.print(": ");
            new Autocomplete(in, out).solve();
        }
        out.flush();
    }
}

class Node {
    Node[] childs = new Node['z' - 'a' + 1];
}