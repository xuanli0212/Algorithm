public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        
        if (m + n != s3.length()) {
            return false;
        }
        
        //state: s3的前i+j个字符是由s1前i个和s2前j个教体组成
        boolean[][] f = new boolean[m + 1][n + 1];
        
        //initial
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)){
                f[i][0] = true;  
            }
          
        }
        for (int i = 1; i <= n; i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1)){
                f[0][i] = true;  
            }
        }
        //function
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (f[i - 1][j] && s3.charAt(i + j -1) == s1.charAt(i - 1) ||  f[i][j - 1] && s3.charAt(i + j -1) == s2.charAt(j - 1)) {
                    f[i][j] = true;
                } 
            }
        }
        
        return f[m][n];
    }
}
