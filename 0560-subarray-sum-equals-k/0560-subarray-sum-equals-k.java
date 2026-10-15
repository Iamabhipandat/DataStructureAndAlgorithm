class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : nums) {

            prefix += num;

            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }

            if (map.containsKey(prefix)) {
                map.put(prefix, map.get(prefix) + 1);
             } else {
                     map.put(prefix, 1);
                  }
        }

        return count;
    }
}