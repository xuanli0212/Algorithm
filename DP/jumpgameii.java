public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] f = new int[n];
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (A[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    f[i] = f[j] + 1;
                    break;
                } 
            }
        }
        return f[n - 1];
    }
}
/*
* Greedy Method
*/
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int far = A[0];
        int step = 0;
        int start = 0;
        int end = 0;
        while (end < A.length -1){
            for (int i = start; i <= end; i++) {
                if (i + A[i] > far) {
                    far = i + A[i];
                }
            }
            start = end + 1;
            end = far;
            step++;
        }
        return step;
    }
}
