class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int j = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.get(nums[i]) > k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                j++;
            }

            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}