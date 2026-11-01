class Solution {
    public int minMoves(int[] nums) {
int n = nums.length;
        int min = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            min = Math.min(min, nums[i]);
            sum += nums[i];

        }

        return sum - min*n;
    }
}