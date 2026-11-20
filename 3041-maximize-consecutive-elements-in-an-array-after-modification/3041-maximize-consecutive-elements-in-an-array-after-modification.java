import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int num : nums) {

            // Option 1: Increase current element by 1
            dp.put(num + 1,
                Math.max(dp.getOrDefault(num + 1, 0),
                         dp.getOrDefault(num, 0) + 1));

            // Option 2: Keep current element unchanged
            dp.put(num,
                Math.max(dp.getOrDefault(num, 0),
                         dp.getOrDefault(num - 1, 0) + 1));

            ans = Math.max(ans, Math.max(
                dp.getOrDefault(num, 0),
                dp.getOrDefault(num + 1, 0)
            ));
        }

        return ans;
    }
}