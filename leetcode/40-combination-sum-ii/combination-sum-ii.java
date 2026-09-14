class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCobinationSum(candidates, target, 0, 0, ans, new ArrayList<>());
        return ans;
    }

    public void findCobinationSum(int[] nums, int k, int idx, int sum, List<List<Integer>> ans, List<Integer> tmp){
        if(k==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            if(k<0) return;
            tmp.add(nums[i]);
            findCobinationSum(nums,k-nums[i],i+1,sum,ans,tmp);
            tmp.remove(tmp.size()-1);
            }
        }  
}