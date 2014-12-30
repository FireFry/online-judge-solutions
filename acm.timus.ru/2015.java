import java.io.*;

public class Solution {
    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws IOException {
        int maxCost = readInt();
        int advAloneOne = readInt();
        int advAloneTwo = readInt();

        int n = readInt();
        int[] maxFriendCost = new int[n];
        int[] advFriend = new int[n];
        for (int i = 0; i < n; i++) {
            maxFriendCost[i] = readInt();
            advFriend[i] = readInt();
        }

        int m = readInt();
        int maxAdv = -1;
        int maxAp = 0;
        int maxFriend = 0;
        for (int i = 0; i < m; i++) {
            int rooms = readInt();
            int cost = readInt();
            int adv = readInt();

            if (rooms == 1) {
                if (cost <= maxCost && adv + advAloneOne > maxAdv) {
                    maxAdv = adv + advAloneOne;
                    maxAp = i + 1;
                    maxFriend = 0;
                }
            } else {
                if (cost <= maxCost && adv + advAloneTwo > maxAdv) {
                    maxAdv = adv + advAloneTwo;
                    maxAp = i + 1;
                    maxFriend = 0;
                }
                for (int j = 0; j < n; j++) {
                    if (cost <= maxCost * 2 && cost <= maxFriendCost[j] * 2 && adv + advFriend[j] > maxAdv) {
                        maxAdv = adv + advFriend[j];
                        maxAp = i + 1;
                        maxFriend = j + 1;
                    }
                }
            }
        }

        if (maxAp == 0) {
            out.println("Forget about apartments. Live in the dormitory.");
        } else if (maxFriend == 0) {
            out.println("You should rent the apartment #" + maxAp + " alone.");
        } else {
            out.println("You should rent the apartment #" + maxAp + " with the friend #" + maxFriend + ".");
        }

        out.flush();
    }

    int mod(int x) {
        return x % 1000000007;
    }

    int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}
