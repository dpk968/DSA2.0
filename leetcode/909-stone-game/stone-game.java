class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }






        // int l=0,r=piles.length-1;
        // int[][] dp = new int[r+1][r+1];
        // int diff = getTotalPilesDiff(piles,l,r,dp);
        // return diff>=0;
    // }

    public int getTotalPilesDiff(int[] piles, int s, int e,int[][] dp){
        if(s==e) return piles[s];

        if(dp[s][e]!=0) return dp[s][e];
        int left = piles[s] - getTotalPilesDiff(piles,s+1,e,dp);
        int right = piles[e] - getTotalPilesDiff(piles,s,e-1,dp);

        return dp[s][e]=Math.max(left,right);
    }
}