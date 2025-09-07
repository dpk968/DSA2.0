package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] arr = {"hot","dot","dog","lot","log","cog"};

        List<List<String>> len = findPathMaxLength(begin,end,arr);
        System.out.println("len: "+len);
    }

    private static List<List<String>> findPathMaxLength(String begin, String end, String[] arr) {
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        Queue<List<String>> q = new LinkedList<>();
        List<List<String>> ans = new ArrayList<>();

        List<String> elments = new ArrayList<>();

        elments.add(begin);
        q.add(elments);
        

        while (!q.isEmpty()) {
            List<String> e = q.poll();
            if(e.get(e.size()-1).equals(end)){
                ans.add(e);
            }else{
                bfs(e,set,q,end);
            }
        }
        
       return ans;
    }

    private static void bfs(List<String> p, Set<String> set, Queue<List<String>> q, String end) {
        String ele = p.get(p.size()-1);
       for (int i = 0; i < ele.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char currChar = (char)('a'+j);
                String newStr = ele.substring(0, i) +currChar +ele.substring(i+1);
                if (set.contains(newStr)) {
                    List<String> temp = new ArrayList<>(p);
                    temp.add(newStr);
                    q.add(temp);
                    if(!newStr.equals(end)){
                        set.remove(newStr);
                    }
                }
            }
       }
    }
}
