import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp =
            new HashMap<>(nums.length * 2);

        int ans = 0;

        for (int x : nums) {
            int prev = dp.getOrDefault(x - 1, 0);
            int curr = dp.getOrDefault(x, 0);
            int next = dp.getOrDefault(x + 1, 0);

            int keep = Math.max(curr, prev + 1);
            int inc = Math.max(next, curr + 1);

            dp.put(x, keep);
            dp.put(x + 1, inc);

            ans = Math.max(ans, Math.max(keep, inc));
        }

        return ans;
    }
}