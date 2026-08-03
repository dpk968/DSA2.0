import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LexiOrder2 {
    public static String getKLexiPalindrome(String s, int k) {

        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // StringBuilder firstHalf = new StringBuilder();
        String middle = "";

        // FIX:
        // You only needed the length of firstHalf, not the string itself.
        int len = 0;

        for (char key : map.keySet()) {
            int times = map.get(key);

            if (times % 2 == 1) {
                middle = String.valueOf(key);
            }

            // for(int i=0;i<times/2;i++){
            // firstHalf.append(key);
            // }

            // FIX:
            len += times / 2;

            map.put(key, times / 2);
        }

        List<Character> lst = new ArrayList<>(map.keySet());

        // int startWith = 0;

        // int len = firstHalf.length();

        StringBuilder orderStr = new StringBuilder();

        // while (map.size()!=0) {

        // FIX:
        // Stop after placing all half characters.
        while (len > 0) {

            // FIX:
            // Every new position should again start checking
            // from the smallest available character.
            for (int i = 0; i < lst.size(); i++) {

                char ch = lst.get(i);

                int total = getWordCount(map, ch, len, k);

                if (k >= total) {

                    k = k - total;

                    // startWith++;

                    // FIX:
                    // No startWith.
                    // Continue checking next character.

                } else {

                    // orderStr.append(lst.get(startWith));

                    // FIX:
                    orderStr.append(ch);

                    len--;

                    // int fre = map.get(lst.get(startWith))-1;

                    // FIX:
                    int fre = map.get(ch) - 1;

                    if (fre == 0) {

                        // lst.remove(startWith);
                        // map.remove(lst.get(startWith));

                        // FIX:
                        // Save character before removing.
                        map.remove(ch);
                        lst.remove(i);

                    } else {

                        // map.put(lst.get(startWith), fre);

                        // FIX:
                        map.put(ch, fre);
                    }

                    // FIX:
                    // Character chosen for this position.
                    // Move to next position.
                    break;
                }
            }
        }

        return orderStr.toString()
                + middle
                + orderStr.reverse().toString();
    }

    public static int combo(int n, int r, int limit) {
        int ans = 1;

        for (int i = 1; i <= r; i++) {

            ans *= (n - r + i);

            ans /= i;

            if (ans > limit)
                return limit + 1;
        }
        return ans;
    }

    public static int getWordCount(Map<Character, Integer> map,
            char startWith,
            int len, int k) {

        // int fac = fact(len);

        // FIX:
        // One character is already fixed.
        int fac = fact(len - 1, k);
        if (fac > k) {
            return fac;
        }

        int denominatorFact = 1;

        for (char key : map.keySet()) {

            int valFact = (key == startWith)
                    ? map.get(key) - 1
                    : map.get(key);

            denominatorFact *= fact(valFact, k);
        }

        return fac / denominatorFact;
    }

    public static int fact(int n, int k) {

        if (n <= 0) {
            return 1;
        }

        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
            if (result > k) {
                return k + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getKLexiPalindrome("aaabbbaaa", 4));
        ;
    }
}
