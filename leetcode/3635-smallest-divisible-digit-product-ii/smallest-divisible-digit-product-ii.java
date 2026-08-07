class Solution {
    public String smallestNumber(String num, long t) {

        int n = num.length();

        // t must contain only prime factors 2, 3, 5, 7.
        long tmp = t;
        int[] primes = {2, 3, 5, 7};

        for (int p : primes) {
            while (tmp % p == 0) {
                tmp /= p;
            }
        }

        if (tmp != 1) {
            return "-1";
        }

        /*
         * remaining[i] =
         * factor requirement remaining after processing
         * num[0 ... i-1].
         */
        long[] remaining = new long[n + 1];

        remaining[0] = t;

        for (int i = 0; i < n; i++) {

            int digit = num.charAt(i) - '0';

            remaining[i + 1] =
                    remaining[i] / gcd(remaining[i], digit);
        }

        // num itself is already the answer.
        if (num.indexOf('0') == -1 && remaining[n] == 1) {
            return num;
        }

        /*
         * Find the first zero.
         *
         * If there is a zero at position z, we must change
         * position z or an earlier position.
         */
        int firstZero = num.indexOf('0');

        int start = (firstZero == -1) ? n - 1 : firstZero;

        /*
         * Try to increase one digit.
         *
         * We go from right to left so that the resulting number
         * is as small as possible.
         */
        for (int i = start; i >= 0; i--) {

            int currentDigit = num.charAt(i) - '0';

            long required = remaining[i];

            int freeSlots = n - i - 1;

            /*
             * Try the smallest possible larger digit.
             */
            for (int digit = currentDigit + 1;
                 digit <= 9;
                 digit++) {

                long newRequired =
                        required / gcd(required, digit);

                /*
                 * Can the remaining slots satisfy the requirement?
                 */
                if (minDigits(newRequired) <= freeSlots) {

                    String suffix =
                            buildSuffix(newRequired, freeSlots);

                    return num.substring(0, i)
                            + (char) ('0' + digit)
                            + suffix;
                }
            }
        }

        /*
         * No answer with the same number of digits.
         *
         * Find the minimum number of digits needed for t.
         */
        int minLength = minDigits(t);

        int answerLength = Math.max(n + 1, minLength);

        return buildSuffix(t, answerLength);
    }


    /*
     * Returns the minimum number of NON-1 digits required
     * to make the digit product divisible by required.
     */
    private int minDigits(long required) {

        if (required == 1) {
            return 0;
        }

        int[] f = factorize(required);

        int count2 = f[0];
        int count3 = f[1];
        int count5 = f[2];
        int count7 = f[3];

        /*
         * Every 5 and 7 needs one digit.
         */
        int answer = Integer.MAX_VALUE;

        /*
         * Try using x digits of 6.
         *
         * 6 = 2 * 3
         *
         * Remaining 2s are optimally represented using 8s.
         * Remaining 3s are optimally represented using 9s.
         */
        for (int x = 0;
             x <= Math.min(count2, count3);
             x++) {

            int remaining2 = count2 - x;
            int remaining3 = count3 - x;

            int digitsFor2 =
                    (remaining2 + 2) / 3; // 8 = 2^3

            int digitsFor3 =
                    (remaining3 + 1) / 2; // 9 = 3^2

            int total =
                    x
                    + digitsFor2
                    + digitsFor3
                    + count5
                    + count7;

            answer = Math.min(answer, total);
        }

        return answer;
    }


    /*
     * Build the lexicographically smallest zero-free number
     * of exactly 'slots' digits.
     */
    private String buildSuffix(long required, int slots) {

        int minimum = minDigits(required);

        if (minimum > slots) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        /*
         * 1 contributes nothing to the product.
         *
         * Since 1 is the smallest digit, put all unnecessary
         * positions as 1 at the beginning.
         */
        int ones = slots - minimum;

        for (int i = 0; i < ones; i++) {
            result.append('1');
        }

        /*
         * Construct exactly 'minimum' useful digits.
         */
        long remaining = required;

        int remainingSlots = minimum;

        while (remainingSlots > 0) {

            /*
             * Try digits in increasing order.
             */
            for (int digit = 2; digit <= 9; digit++) {

                long next =
                        remaining / gcd(remaining, digit);

                /*
                 * We need exactly remainingSlots - 1
                 * useful digits after choosing this digit.
                 */
                if (minDigits(next) == remainingSlots - 1) {

                    result.append((char) ('0' + digit));

                    remaining = next;
                    remainingSlots--;

                    break;
                }
            }
        }

        return result.toString();
    }


    /*
     * Factorize into:
     *
     * 2^a * 3^b * 5^c * 7^d
     */
    private int[] factorize(long value) {

        int[] result = new int[4];

        int[] primes = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {

            while (value % primes[i] == 0) {
                result[i]++;
                value /= primes[i];
            }
        }

        return result;
    }


    private long gcd(long a, long b) {

        while (b != 0) {

            long temp = a % b;

            a = b;
            b = temp;
        }

        return a;
    }
}