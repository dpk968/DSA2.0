import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        // Test the function with some examples
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(" characters: " + lengthOfLongestSubstring(str));


        sc.close();
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int l = 0;
        int r = 0;
        int maxLen = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        while(r < n){
            if(map.get(s.charAt(r)) != null){
                if(map.get(s.charAt(r))+1>l){
                    l = map.get(s.charAt(r))+1;
                }
            }
            if(r-l+1 > maxLen){
                maxLen = r - l + 1;
            }
            map.put(s.charAt(r), r);
            r++;
        
    }
        return maxLen;
    }
}
