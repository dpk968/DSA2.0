class Solution {
    public boolean check(int[] nums) {
        if(nums.length==1) return true;
        int cnt = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) cnt++;
        }
        if(nums[nums.length-1]>nums[0]) cnt++;
        return cnt<=1;
    }
}