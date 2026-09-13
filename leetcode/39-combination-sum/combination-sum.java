class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCobinationSum(candidates, target, 0, 0, ans, new ArrayList<>());
        return ans;
    }

    public void findCobinationSum(int[] nums, int k, int sum, int idx, List<List<Integer>> ans, List<Integer> tmp) {
        if (sum == k) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (idx == nums.length || sum > k) {
            return;
        }

        tmp.add(nums[idx]);
        findCobinationSum(nums, k, sum + nums[idx], idx, ans, tmp);
        tmp.remove(tmp.size() - 1);
        findCobinationSum(nums, k, sum, idx + 1, ans, tmp);

    }
}