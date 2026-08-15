class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int zeros = 0;

        for (int num : nums) {
            xor ^= num;

            if (num == 0) {
                zeros++;
            }
        }

        // Entire array has non-zero XOR
        if (xor != 0) {
            return nums.length;
        }

        // All elements are zero
        if (zeros == nums.length) {
            return 0;
        }

        // XOR is 0, but at least one non-zero element exists
        return nums.length - 1;
    }
}