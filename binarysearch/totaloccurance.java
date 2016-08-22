public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        int firstPosition = -1;
       
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            }else if (A[mid] < target) {
                start = mid;    
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            firstPosition = start;
        } else if (A[end] == target) {
            firstPosition = end;
        } else {
            return 0;
        }
        int count = 0;
        while (firstPosition < A.length && A[firstPosition] == target ) {
            count++;
            firstPosition++;
        }
        return count;
        
    }
}
