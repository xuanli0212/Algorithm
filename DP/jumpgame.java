public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return true;
        }
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j ] && ( j + A[j] >= i )) {
                    f[i] = true;
                    break;
                }
                f[i] = false;
            }
        }
        return f[n - 1];
    }
}
