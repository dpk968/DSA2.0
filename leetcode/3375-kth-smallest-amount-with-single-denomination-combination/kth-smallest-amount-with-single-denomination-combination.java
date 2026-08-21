class Solution {
    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        long low = 1;
        long high = 1_000_000_000_000L;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins, n) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins, int n) {
        long result = 0;

        for (int mask = 1; mask < (1 << n); mask++) {

            long LCM = 1;
            boolean valid = true;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    LCM = lcm(LCM, coins[i]);

                    if (LCM > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long value = x / LCM;

            if ((bits & 1) == 1) {
                result += value;
            } else {
                result -= value;
            }
        }

        return result;
    }

}