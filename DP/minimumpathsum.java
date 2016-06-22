public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        // state
        int[][] f = new int[n][m];
        //Initialization
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];  
        }
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        //function
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[n - 1][m - 1];
    }
}
