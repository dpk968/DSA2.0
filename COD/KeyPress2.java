import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KeyPress2 {
    public static void main(String[] args) {
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }
    public static int minimumPushes(String word) {
        
        Map<Character,Integer> map = new TreeMap<>();
        
        int keyPress = 0;
        for(char ch:word.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        TreeMap<Character, Integer> sortedmap = new TreeMap<>((k1, k2) -> {
            int cmp = map.get(k2).compareTo(map.get(k1));
            return (cmp == 0) ? k2.compareTo(k1) : cmp; 
        });
        sortedmap.putAll(map);
        int cnt = 0;
        for(char key:sortedmap.keySet()){
            keyPress += ((cnt++/8)+1)*sortedmap.get(key);
        }

        return keyPress;
    }
}
