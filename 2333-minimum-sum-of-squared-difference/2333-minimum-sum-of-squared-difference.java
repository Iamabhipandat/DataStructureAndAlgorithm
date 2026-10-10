
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        long k = (long) k1 + k2;
        if (sum <= k) return 0;

        int lo = 0, hi = max;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) needed += d - mid;
            }

            if (needed <= k) hi = mid;
            else lo = mid + 1;
        }

        int level = lo;
        long answer = 0;
        long used = 0;

        for (int d : diff) {
            int reduced = Math.min(d, level);
            used += d - reduced;
            answer += (long) reduced * reduced;
        }

        long remaining = k - used;

        for (int d : diff) {
            if (remaining == 0) break;

            if (d >= level && d > 0) {
                // Only differences originally above the level
                // need special care; use the reduced value instead.
            }
        }

        // Recompute safely: after leveling, reduce remaining
        // threshold-valued differences by one.
        for (int d : diff) {
            if (remaining == 0) break;

            if (d >= level && level > 0) {
                answer -= (long) level * level;
                answer += (long) (level - 1) * (level - 1);
                remaining--;
            }
        }

        return answer;
    }
}

