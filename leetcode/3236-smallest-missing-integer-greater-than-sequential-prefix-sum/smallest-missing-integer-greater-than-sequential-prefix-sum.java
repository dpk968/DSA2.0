class Solution {
    public int missingInteger(int[] nums) {

        Set<Integer> map = new HashSet<>();
        for(int e:nums){
            map.add(e);
        }

        int sum = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1==nums[i])
                sum += nums[i];
            else
                break;
        }

        while(map.contains(sum)){
            sum++;
        }
        return sum;
    }
}