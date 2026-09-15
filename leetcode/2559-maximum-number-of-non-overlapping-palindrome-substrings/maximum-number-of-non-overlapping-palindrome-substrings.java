class Solution {
    public static int len=0;
    public boolean isPlindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
    public int maxPalindromes(String s, int k) {

        len = s.length();
        if(k==1) return len;
        int[][] dp = new int[len+1][len+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,k,0,k-1,dp);
        
    }
    public int solve(String s, int k, int i, int j,int[][] dp){
        if(i>=len || j >= len) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int takeIt = Integer.MIN_VALUE;
        if(isPlindrome(s,i,j)){
            takeIt = 1+ solve(s,k,j+1,j+k,dp);
            // int notTake = solve(s,k,i+1,j+1,dp);
            // int shift = solve(s,k,i,j+1,dp);

            // return dp[i][j] = Math.max(takeIt, Math.max(notTake, shift));
        }

        int notTake = solve(s,k,i+1,j+1,dp);
        int shift = solve(s,k,i,j+1,dp);

        return dp[i][j] = Math.max(takeIt, Math.max(notTake, shift));

    }
}