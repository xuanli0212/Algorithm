public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }
        int m = A.length();
        int n = B.length();
        //state
        int[][] f = new int[m + 1][n + 1];
        //initial
        int max = 0;
        //
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)){
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = 0;
                }
                if (f[i][j] > max) {
                    max = f[i][j];
                }
            }
        }
        return max;
    }
}
