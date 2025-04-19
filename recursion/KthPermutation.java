package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KthPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // List<Integer> arr = new ArrayList<>();
        // List<List<Integer>> ans = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        // arr.add(i+1);
        // }
        // getAllOfLengthK(n,k,ans,0,arr);

        String ans = getAllKPermutation(n, k);
        System.out.println(ans);

        sc.close();

    }

    public static String getAllKPermutation(int n, int k) {
        String ans = "";

        List<Integer> arr = new ArrayList<>();
        int fact = 1;
        for (int i = 0; i < n; i++) {
            arr.add(i+1);
            fact *= (i+1);
        }

        fact = fact/arr.size();

        while (!arr.isEmpty()) {
            ans+=arr.get(k/fact);
            arr.remove(k/fact);
            if(arr.isEmpty()){
                break;
            }
            k=k%fact;
            fact=fact/arr.size();
        }

        return ans;
    }

    public static void getAllOfLengthK(int n, int k, List<List<Integer>> ans, int idx, List<Integer> arr) {
        if (idx == n) {
            ans.add(new ArrayList<>(arr));
            System.out.println(arr);
            return;
        }

        for (int i = idx; i < n; i++) {
            swap(arr, idx, i);
            getAllOfLengthK(n, k, ans, idx + 1, arr);
            swap(arr, idx, i);
        }

    }

    public static void swap(List<Integer> arr, int s, int e) {
        int temp = arr.get(s);
        arr.set(s, arr.get(e));
        arr.set(e, temp);

    }
}
