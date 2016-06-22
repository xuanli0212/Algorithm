public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int n = nums.length;
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                    }
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
}
