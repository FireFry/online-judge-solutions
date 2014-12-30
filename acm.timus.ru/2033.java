import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws Exception {
        HashMap<String, Integer> prices = new HashMap<String, Integer>();
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for (int i = 0; i < 6; i++) {
            String name = in.readLine();
            String phone = in.readLine();
            int price = readInt();
            if (!prices.containsKey(phone) || prices.get(phone) > price) {
                prices.put(phone, price);
            }
            counts.put(phone, counts.containsKey(phone) ? counts.get(phone) + 1 : 1);
        }
        Iterator<String> iterator = prices.keySet().iterator();
        String minPhone = iterator.next();
        while (iterator.hasNext()) {
            String phone = iterator.next();
            if (counts.get(phone) > counts.get(minPhone) || counts.get(phone).equals(counts.get(minPhone)) && prices.get(phone) < prices.get(minPhone)) {
                minPhone = phone;
            }
        }
        out.println(minPhone);
        out.flush();
    }

    int readInt() throws Exception {
        return Integer.parseInt(in.readLine());
    }

    public static void main(String[] args) throws Exception {
        new Solution().solve();
    }

}
