class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        // 1. Block every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
            }
        }

        // 2. Open the first row
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }

        // 3. Open the last column
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }

        // 4. Convert each row into a String
        String[] result = new String[m];

        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }
}