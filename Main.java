import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
       
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		int a[] = new int[m];
		int b[] = new int[n];

		for (int i = 0; i < m; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}

		System.out.println(sortedArray(a, b));

    }

	public static List<Integer> sortedArray(int []a, int []b) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
				if(!ans.contains(a[i]))
                	ans.add(a[i]);
                i++;
            }else{
				if(!ans.contains(b[j])){
					ans.add(b[j]);
				}
				j++;
            }
        }

        while(i<a.length){
			if(!ans.contains(a[i]))
                	ans.add(a[i]);
                i++;
        }
        while(j<b.length){
            if(!ans.contains(b[j])){
				ans.add(b[j]);
			}
			j++;
        }

        return ans;
    }

}
