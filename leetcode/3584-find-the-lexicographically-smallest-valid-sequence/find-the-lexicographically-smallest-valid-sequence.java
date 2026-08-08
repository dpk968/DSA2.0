class Solution {
    public int[] validSequence(String word1, String word2) {

        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        int n = c1.length;
        int m = c2.length;

        /*
         * dp[i] = number of characters from the END of word2
         * that can be matched exactly using word1[i...n-1].
         */
        int[] dp = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            if (j >= 0 && c1[i] == c2[j]) {
                dp[i] = dp[i + 1] + 1;
                j--;
            } else {
                dp[i] = dp[i + 1];
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        /*
         * Greedily select the smallest possible index.
         */
        while (i < n && j < m) {

            // Exact match
            if (c1[i] == c2[j]) {

                ans[j] = i;
                j++;

            } else {

                /*
                 * Use our one allowed mismatch here.
                 *
                 * After using i for word2[j], we need
                 * m-j-1 characters to be matched exactly.
                 *
                 * dp[i+1] tells us how many characters
                 * from the end can be matched.
                 */
                if (dp[i + 1] >= m - 1 - j) {

                    ans[j] = i;
                    j++;

                    // Mismatch is used.
                    i++;

                    break;
                }
            }

            i++;
        }

        /*
         * If we couldn't select all characters,
         * no valid answer exists.
         */
        if (j < m && i == n) {
            return new int[0];
        }

        /*
         * Now the mismatch has already been used,
         * so we can only select exact matches.
         */
        while (j < m && i < n) {

            if (c1[i] == c2[j]) {
                ans[j] = i;
                j++;
            }

            i++;
        }

        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}