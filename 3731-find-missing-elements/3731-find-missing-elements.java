class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = nums[0];
        int end = nums[n - 1];

        List<Integer> arr = new ArrayList<>();

        for (int i = start; i <= end; i++) {
                 final int current = i;
            if (Arrays.stream(nums).noneMatch(x -> x == current)) {
                arr.add(i);
            }
        }

        return arr;
    }
}
