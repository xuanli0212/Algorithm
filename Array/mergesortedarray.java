class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m;
        int j = n;
        int index = m + n;
        while (j > 0) {
            if (i > 0 && A[i - 1] >= B[j - 1]) {
                A[index - 1] = A[i - 1];
                i--;
            }else {
                A[index - 1] = B[j - 1];
                j--;
            }
            index--;
        }
    }
}
