package linearSearch;

public class AddSumOf2DArray {
    public static void main(String[] args) {

    }
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
                if (sum > ans) {
                    ans = sum;
                }

            }
        }
        return ans;

    }
}
