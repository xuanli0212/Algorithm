public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null) {
            return 0;
        }
        int m = S.length();
        int n = T.length();
        //state
        int[][] f = new int[m + 1][n + 1];
        //initialize
        for (int i = 0; i <= m; i++) {
            f[i][0] = 1;
        }

        //function
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }
}
