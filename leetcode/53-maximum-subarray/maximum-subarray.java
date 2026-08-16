class Solution {
    public int maxSubArray(int[] nums) {
        int l=0;
        int n = nums.length;
        if(n==1) return nums[0];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while(l<n){
            sum += nums[l];
            max = Math.max(max,sum);
            if(sum<0){
                sum = 0;
            }
            l++;
        }
        return max;
    }
}