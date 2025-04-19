package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitionPalidrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        getAllPartitionPalidromE(s,res,0,ans);

        System.out.println(res);

        sc.close();
    }

    public static void getAllPartitionPalidromE(String s, List<List<String>> res,int idx, List<String> ans){
        if(idx==s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if(isPalindrome(s,idx,i)){
                ans.add(s.substring(idx, i+1));
                getAllPartitionPalidromE(s, res, idx+1,ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String str, int s, int e){
        while (s<=e) {
            if(str.charAt(s++)!=str.charAt(e--)){
                return false;
            }
        }
        return true;
    }
}
