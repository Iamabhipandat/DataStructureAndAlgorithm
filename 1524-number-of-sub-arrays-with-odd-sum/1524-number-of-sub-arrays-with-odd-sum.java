
class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;

        long even = 1;
        long odd = 0;
        long count = 0;

        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                count = (count + odd) % MOD;
                even++;
            } else {
                count = (count + even) % MOD;
                odd++;
            }
        }

        return (int) count;
    }
}
