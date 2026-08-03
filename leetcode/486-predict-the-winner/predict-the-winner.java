class Solution {
    public boolean predictTheWinner(int[] nums) {
         int l=0,r=nums.length-1;

        int diff = getScoreDiff(l,r,nums);

        return diff>=0;
    }
    public int getScoreDiff(int l, int r, int[] nums){
        if(l==r){
            return nums[l];
        }

        int leftChose = nums[l] - getScoreDiff(l+1, r, nums);
        int rightChoose = nums[r] - getScoreDiff(l, r-1, nums);


        return Math.max(leftChose, rightChoose);
    }
}