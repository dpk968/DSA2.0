class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n];
        prefix[0] = stoneValue[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+stoneValue[i];
        }
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,n-1,prefix,dp);
    }

    public int solve(int s, int e, int[] prefix,int[][] dp){
        if(s>=e){
            return 0;
        }
        if(dp[s][e] != -1){
            return dp[s][e];
        }
        int score = 0;
        for(int mid=s;mid<=e-1;mid++){
            int left = prefix[mid] - (s-1>=0?prefix[s-1]:0);
            int right = prefix[e] - prefix[mid];

            if(left < right) { 
                score = Math.max(score, left + solve(s, mid, prefix,dp)); 
            } else if(left > right) { 
                score = Math.max(score, right + solve(mid+1, e, prefix,dp)); 
            } else { 
            score = Math.max(score, Math.max(left + solve(s, mid, prefix,dp), right + solve(mid+1, e, prefix,dp)));
            }
        }
        return dp[s][e]=score;
    }
}