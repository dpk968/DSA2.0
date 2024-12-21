package basicsWarmUp;
import java.util.Arrays;
import java.util.Scanner;

public class CountFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(countFrequency(n, x, arr)));
        sc.close();
    }
    public static int[] countFrequency(int n, int x, int []nums){
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if(nums[i]<= n){
                ans[nums[i]-1] = ans[nums[i]-1]+1;
            }
        }
        return ans;
    }
}
