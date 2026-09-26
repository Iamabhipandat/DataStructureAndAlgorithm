import java.util.*;

class Solution {
    public long maximumScore(int[][] grid) {

        int n = grid.length;

        // prefix[col][i] = sum of first i elements of this column
        long[][] prefix = new long[n][n + 1];

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                prefix[col][row + 1] =
                    prefix[col][row] + grid[row][col];
            }
        }

        long NEG = Long.MIN_VALUE / 2;

        // dp[h1][h2]
        long[][] dp = new long[n + 1][n + 1];

        for (long[] row : dp) {
            Arrays.fill(row, NEG);
        }

        // Before processing columns,
        // previous height can be anything, current height = 0
        for (int h = 0; h <= n; h++) {
            dp[h][0] = 0;
        }

        for (int col = 0; col < n - 1; col++) {

            long[][] next = new long[n + 1][n + 1];

            for (long[] row : next) {
                Arrays.fill(row, NEG);
            }

            for (int h1 = 0; h1 <= n; h1++) {

                // prefix maximum
                long[] pre = new long[n + 2];
                pre[0] = dp[h1][0];

                for (int h2 = 1; h2 <= n; h2++) {
                    pre[h2] = Math.max(pre[h2 - 1], dp[h1][h2]);
                }

                // suffix maximum
                long[] suf = new long[n + 2];

                for (int h2 = n; h2 >= 0; h2--) {

                    long value = NEG;

                    if (dp[h1][h2] != NEG) {
                        value = dp[h1][h2]
                              + Math.max(
                                  0L,
                                  prefix[col][h2] - prefix[col][h1]
                                );
                    }

                    suf[h2] = Math.max(suf[h2 + 1], value);
                }

                for (int hp = 0; hp <= n; hp++) {

                    // Case 1:
                    // hp <= h2
                    long add =
                        Math.max(
                            0L,
                            prefix[col][hp] - prefix[col][h1]
                        );

                    long value1 = NEG;

                    if (pre[hp] != NEG) {
                        value1 = pre[hp] + add;
                    }

                    // Case 2:
                    // h2 > hp
                    long value2 = suf[hp + 1];

                    next[hp][h1] =
                        Math.max(value1, value2);
                }
            }

            dp = next;
        }

        long ans = 0;

        for (int h1 = 0; h1 <= n; h1++) {
            for (int h2 = 0; h2 <= n; h2++) {

                if (dp[h1][h2] != NEG) {

                    ans = Math.max(
                        ans,
                        dp[h1][h2]
                        + Math.max(
                            0L,
                            prefix[n - 1][h2]
                            - prefix[n - 1][h1]
                        )
                    );
                }
            }
        }

        return ans;
    }
}