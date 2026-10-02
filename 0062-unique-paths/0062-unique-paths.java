class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        return solve(m, n, dp);
    }

    public int solve(int m, int n, int[][] dp) {

        // Base case
        if (m == 1 || n == 1) {
            return 1;
        }

        // Already calculated
        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        dp[m][n] = solve(m - 1, n, dp)
                 + solve(m, n - 1, dp);

        return dp[m][n];
    }
}