class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int low=0,high=c-1;
        int[] res = new int[2];
        while(low<=high){
            int mid = (low+high)/2;
            int row = findMax(mat,mid);
            int left = mid-1>=0? mat[row][mid-1]:-1;
            int right = mid+1<c?mat[row][mid+1]:-1;
            if(left < mat[row][mid] && right < mat[row][mid]){
                res[0] = row;
                res[1] = mid;
                return res; 
            }else if(left > mat[row][mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }

    public int findMax(int[][] mat, int col){
        int max = -1;
        int idx = -1;
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]>max){
                idx = i;
                max = mat[i][col];
            }
        }
        return idx;
    }

}