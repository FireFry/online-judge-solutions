/**
 * Given a key string {@code k} and an integer {@code k} you need to remove all dashes from string, convert all 
 * characters to upper case and insert dashes to split with them key string on pieces of {@code k} characters.
 * There can be only one piece with size greater than zero and lower than {@code k} characters long, which should come
 * first in the result string.
 * 
 * Sample input: a3bc-D-e5F 3
 * Sample output: A3-BCD-E5F
 */
public class FixKeyString {
    
    public static String solve(String s, int k) {
        int dashes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                dashes++;
            }
        }
        
        int usefulChars = s.length() - dashes;
        int resultDashes = (usefulChars - 1) / k;
        
        int resultLength = usefulChars + resultDashes;
        
        StringBuilder b = new StringBuilder(resultLength);
        b.setLength(resultLength);
        
        int bi = b.length() - 1;
        int dashCountdown = k;
        
        for (int si = s.length() - 1; si >= 0; si--) {
            char ch = s.charAt(si);
            if (ch != '-') {
                b.setCharAt(bi, Character.toUpperCase(ch));
                bi--;
                dashCountdown--;
                if (bi > 0 && dashCountdown == 0) {
                    b.setCharAt(bi, '-');
                    bi--;
                    dashCountdown = k;
                }
            }
        }
        
        return b.toString();
    }
    
}
