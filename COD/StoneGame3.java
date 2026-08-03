import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoneGame3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6};

        System.out.println(stoneGameIII(arr));
    }

    public static String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int[] dp = new int[n];

        int getScore = scoreDiff(stoneValue,0,dp);

        if(getScore==0) return "Tie";
        else if(getScore>0) return "Alice";
        return "Bob";
    }

    public static int scoreDiff(int[] arr,int idx, int[] dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }
        int best = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < 3 && idx+i<arr.length; i++) {
            sum += arr[i+idx];
            best = Math.max(best, sum-scoreDiff(arr, idx+i+1, dp));
        }
        return dp[idx]=best;
    }

}
