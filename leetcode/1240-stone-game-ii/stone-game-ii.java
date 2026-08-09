class Solution {
    public static int n =0;
    public static int dp[][][] = new int[2][101][101];
    public int stoneGameII(int[] piles) {
        n = piles.length;
        for (int person = 0; person < 2; person++) {
            for (int M = 0; M <= n; M++) {
                Arrays.fill(dp[person][M], -1);
            }
        }

        return solveForAlice(1,piles,1,0);
    }

    public int solveForAlice(int person,int[] piles,int M,int idx){
        if(idx>=n)
            return 0;

        if(dp[person][M][idx] != -1){
            return dp[person][M][idx];
        }
        int res = person==1?-1:Integer.MAX_VALUE;
        int stone = 0;

        for(int x=1;x<=Math.min(2*M,n-idx);x++){
            stone += piles[idx+x-1];

            if(person == 1){ // alice ki baari
                res = Math.max(res, stone+solveForAlice(0,piles,Math.max(M,x),idx+x));
            }else{
                res = Math.min(res,solveForAlice(1,piles,Math.max(M,x),idx+x));
            }
        }

        dp[person][M][idx]=res;
        return res;
    }
}