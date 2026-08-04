class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        List<Integer> old = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            start = nums[i]<start?nums[i]:start;
            end = nums[i]>end?nums[i]:end;
            old.add(nums[i]);
        }
        List<Integer> arr = new ArrayList<>();

        for(int i=start;i<end;i++){
            if(!old.contains(i)){
                arr.add(i);
            }
        }
        return arr;  
    }
}