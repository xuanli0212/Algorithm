public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here  
        if (s == null) {
            return true;
        }
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        int maxLength = getMaxLength(dict);
        
        //function
        for (int i = 1; i <= s.length(); i++) {
            f[i] = false;
            for (int l = 1; l <= maxLength && l <= i;l++) {
                String word = s.substring(i - l, i);
                if (f[i-l] && dict.contains(word)) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
   private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}
