public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        if (n == 0) return true;
        //prepare data structure hash to find if cycle
        HashSet<Integer> set = new HashSet<Integer>();
        int number = n;
        while ( number != 1) {
            int cur = 0;
            while (number > 0) {
                cur = cur + (int)Math.pow(number % 10, 2);
                number = number / 10;
            }
            if (cur == 1) return true;
            if (set.contains(cur)) return false;
            number = cur;
            set.add(number);
        }
        return true;
    }
}
