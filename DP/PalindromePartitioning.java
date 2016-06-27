public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        boolean[][] palindrome = getPalindrome(s);
        //state for the first i characters, the least number of cut needed.
        int[] f = new int[n + 1];
        //initialize. cut one by one, then need i-1 cut.
        for (int i = 0; i <= n; i++) {
            f[i] = i - 1;
        }
        //function
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (palindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n];
    }
    private boolean[][] getPalindrome(String s) {
        int n = s.length();
        //state for start i and end j, it is palindrome
        boolean[][] result = new boolean[n][n];
        //initial
        for (int i = 0; i < n; i++) {
            result[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            result[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        //function
        for (int len = 2; len < n; len++){
            for (int start = 0; start + len < n; start++) {
                if (result[start + 1][ start + len - 1] && s.charAt(start) == s.charAt(start + len)) {
                    result[start][start + len] = true;
                }
            }
        }
        return result;
    }
};
