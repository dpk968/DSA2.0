class Solution {
    public void moveZeroes(int[] nums) {

        int i=0,j=0;
        int n = nums.length;
        if(n==1) return;

        while(j<n){
            while(i<n && nums[i]!=0){
                i++;
            }
            while(j<n && nums[j]==0){
                j++;
            }

            if(i<j && i<n && j<n){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j++;
            }else{
                j++;
            }
            
        }
        
    }
}