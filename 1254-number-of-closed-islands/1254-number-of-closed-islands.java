
class Solution {

    boolean dfshelper(int r, int c, int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return false;
        }
        if (grid[r][c] == 1) {
            return true;
        }

        grid[r][c] = 1;

        boolean up = dfshelper(r - 1, c, grid);
        boolean down = dfshelper(r + 1, c, grid);
        boolean left = dfshelper(r, c - 1, grid);
        boolean right = dfshelper(r, c + 1, grid);

        return up && down && left && right;
    }

    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    if (dfshelper(i, j, grid)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
