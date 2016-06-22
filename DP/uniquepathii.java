public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
         // write your code here 
        if (obstacleGrid == null || obstacleGrid[0] == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] f = new int[m][n];
        f[0][0] = 0;
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1){
                   break;
                }
            f[i][0] = 1;
        }
         for (int i = 0; i < n; i++) {
             if(obstacleGrid[0][i] == 1){
                   break;
             }
            f[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    f[i][j] = 0;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        
        return f[m-1][n-1];
    }
}
