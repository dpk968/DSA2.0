class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        Set<Integer> old = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            start = Math.min(nums[i],start);
            end = Math.max(nums[i],end);
            old.add(nums[i]);
        }
        List<Integer> arr = new ArrayList<>();

        for(int i=start+1;i<end;i++){
            if(!old.contains(i)){
                arr.add(i);
            }
        }
        return arr;  
    }
}