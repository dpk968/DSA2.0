import java.util.Arrays;
import java.util.Scanner;

public class MaxMinCost {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Input the number of elements in the cost array
        int t = sc.nextInt();
        // Input the cost array

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] cost = new int[n];
            int k = sc.nextInt();
            for (int j = 0; j < n; j++) {
                cost[j] = sc.nextInt();
            }
            long result = maximumCost(cost, n, k);
            System.out.println(result); // Output: 6
            
        }


        
    }

    public static long maximumCost(int[] cost, int n, int k) 
	{
        int i=0;
		int j=n-1;

		Arrays.sort(cost);
		long c = 0;
		while(i<=j){
			c += cost[j];
			j--;
			i += k;
		}  

		return c;
    }

    public static long minimumCost(int[] cost, int n, int k) 
	{
		int i=0;
		int j=n-1;

		Arrays.sort(cost);
		long c = 0;
		while(i<=j){
			c += cost[i];
			i++;
			j -= k;
		}  

		return c;
    }
}