import java.io.*;

public class LaserMaze {

    static int[] DI = new int[] {-1, 0, 0, 1};
    static int[] DJ = new int[] {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

        char[][] a = new char[100][100];
        boolean[][][] p = new boolean[4][100][100];
        boolean[][][] h = new boolean[4][100][100];

        for (int t = 1, ts = Integer.parseInt(in.readLine()); t <= ts; t++) {
            String[] lineNM = in.readLine().split(" ");
            int m = Integer.parseInt(lineNM[0]);
            int n = Integer.parseInt(lineNM[1]);

            int si = -1;
            int sj = -1;

            int gi = -1;
            int gj = -1;

            for (int i = 0; i < m; i++) {
                String line = in.readLine();
                for (int j = 0; j < n; j++) {
                    char ch = line.charAt(j);
                    if (ch == 'S') {
                        si = i;
                        sj = j;
                        ch = '.';
                    }
                    if (ch == 'G') {
                        gi = i;
                        gj = j;
                        ch = '.';
                    }
                    a[i][j] = ch;
                }
            }

            for (int pi = 0; pi < p.length; pi++) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        p[pi][i][j] = (i + j + pi) % 2 == (si + sj) % 2;
                    }
                }

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        char ch = a[i][j];
                        int di = 0;
                        int dj = 0;

                        switch (ch) {
                            case '^': di = -1; a[i][j] = '>'; break;
                            case '>': dj =  1; a[i][j] = 'v'; break;
                            case 'v': di =  1; a[i][j] = '<'; break;
                            case '<': dj = -1; a[i][j] = '^'; break;
                            case '#': break;
                            default: continue;
                        }

                        p[pi][i][j] = false;

                        if (di != 0 || dj != 0) {
                            int wi = i + di;
                            int wj = j + dj;
                            while (wi >= 0 && wi < m && wj >= 0 && wj < n && a[wi][wj] == '.') {
                                p[pi][wi][wj] = false;
                                wi += di;
                                wj += dj;
                            }
                        }
                    }
                }
            }

            for (int k = 0; k < h.length; k++) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        h[k][i][j] = false;
                    }
                }
            }
            h[0][si][sj] = true;

            int pi = 1;
            int hprev = 0;
            int hnext = 1;
            int result = 0;
            int step = 0;

            mainLoop:
            while (true) {
                step++;
                boolean duplicate = true;

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        boolean val = false;
                        if (p[pi][i][j]) {
                            for (int k = 0; k < DI.length; k++) {
                                int ni = i + DI[k];
                                int nj = j + DJ[k];
                                if (ni >= 0 && ni < m && nj >= 0 && nj < n && h[hprev][ni][nj]) {
                                    val = true;
                                    break;
                                }
                            }
                        }
                        if (h[hnext][i][j] != val) {
                            h[hnext][i][j] = val;
                            duplicate = false;
                            if (val && i == gi && j == gj) {
                                result = step;
                                break mainLoop;
                            }
                        }
                    }
                }

                if (duplicate) {
                    break;
                }

                hprev = hnext;
                hnext = (hnext + 1) % h.length;
                pi = (pi + 1) % p.length;
            }

            out.print("Case #");
            out.print(t);
            out.print(": ");
            if (result > 0) {
                out.println(result);
            } else {
                out.println("impossible");
            }
        }

        out.flush();
    }

}
