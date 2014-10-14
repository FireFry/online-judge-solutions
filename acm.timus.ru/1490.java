        import java.io.BufferedReader;
        import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        long r = Long.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long r2 = r * r;
        long y = 0;
        long x = r;
        long t = 0;
        while (x > y) {
            y++;
            t += 8 * (x - y) + 4;
            x = (long) Math.ceil(Math.sqrt(r2 - y * y));
        }
        System.out.println(t);
    }

}
