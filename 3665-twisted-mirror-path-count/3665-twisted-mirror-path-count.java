class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;

        // dp[i][j][d] = number of valid paths to the end when the robot is
        // attempting to enter cell (i, j) while moving in direction d
        // d = 0 -> moving right, d = 1 -> moving down
        int[][][] dp = new int[m + 2][n + 2][2];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int d = 0; d < 2; d++) {
                    if (grid[i][j] == 0) {
                        if (i == m - 1 && j == n - 1) {
                            dp[i][j][d] = 1;
                        } else {
                            dp[i][j][d] = (dp[i][j + 1][0] + dp[i + 1][j][1]) % MOD;
                        }
                    } else {
                        if (d == 0) {
                            // moving right into a mirror -> turned down, go to the cell below it
                            dp[i][j][d] = dp[i + 1][j][1];
                        } else {
                            // moving down into a mirror -> turned right, go to the cell right of it
                            dp[i][j][d] = dp[i][j + 1][0];
                        }
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}