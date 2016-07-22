class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A == null && B == null) {
            return (double)0;
        }
        int len = A.length + B.length;
        double result = 0.0;
        if (len % 2 == 1) {
            result = findK(A, 0, B, 0, len/2 + 1);
        } else {
            result = (findK(A, 0, B, 0, len/2) + findK(A, 0, B, 0, len/2 + 1))/2.0;
        }
        return result;
    }
    private int findK(int[] A, int startA, int[] B, int startB, int k) {
        //end condition
         // A -- 0
        // B -- 0
    
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        
        
        int midA = startA + k/2 - 1;
        int midB = startB + k/2 - 1;
        
        // A not enough length
        int keyA = midA > A.length ? Integer.MAX_VALUE : A[midA];
        int keyB = midB > B.length ? Integer.MAX_VALUE : B[midB];
        //B not enough length
       // A 2/k > B 2/K
        if (keyA > keyB ) {
            return findK(A, startA, B, midB + 1, k - k/2);
        } else {
            return findK(A, midA + 1, B, startB, k - k/2);
        }
    }
}
