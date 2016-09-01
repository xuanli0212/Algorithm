class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 0) {
            return -1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        while (n > 1) {
            a = b;
            b = c;
            c = a + b;
            n--;
        }
        return a;
    }
}

