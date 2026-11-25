
import java.util.*;

class Solution {

    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;

    static final long BASE1 = 911382323L;
    static final long BASE2 = 972663749L;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long[] prefix1 = new long[n + 1];
        long[] prefix2 = new long[n + 1];

        long[] power1 = new long[n + 1];
        long[] power2 = new long[n + 1];

        power1[0] = 1;
        power2[0] = 1;

        // Build prefix hashes and powers
        for (int i = 0; i < n; i++) {

            prefix1[i + 1] =
                (prefix1[i] * BASE1 + nums[i]) % MOD1;

            prefix2[i + 1] =
                (prefix2[i] * BASE2 + nums[i]) % MOD2;

            power1[i + 1] =
                (power1[i] * BASE1) % MOD1;

            power2[i + 1] =
                (power2[i] * BASE2) % MOD2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        // Binary search for minimum unique length
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, nums, prefix1, prefix2,
                      power1, power2)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(
        int len,
        int[] nums,
        long[] prefix1,
        long[] prefix2,
        long[] power1,
        long[] power2
    ) {

        int n = nums.length;

        HashMap<Long, Integer> map = new HashMap<>();

        // Generate hashes for all windows of length len
        for (int i = 0; i + len <= n; i++) {

            long h1 = (prefix1[i + len]
                - prefix1[i] * power1[len] % MOD1
                + MOD1) % MOD1;

            long h2 = (prefix2[i + len]
                - prefix2[i] * power2[len] % MOD2
                + MOD2) % MOD2;

            // Combine both hashes
            long key = (h1 << 32) | h2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check whether any subarray appears once
        for (int freq : map.values()) {

            if (freq == 1) {
                return true;
            }
        }

        return false;
    }
}
