public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s ==  null || s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (!isChar(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isChar(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean isChar(char a){
        return Character.isLetter(a) || Character.isDigit(a);
    }
}
