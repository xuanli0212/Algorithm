public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
     if (nums == null || nums.length == 0) {
         return 0;
     }
     if (nums.length == 1) {
         return nums[0];
     }
     int result = Integer.MIN_VALUE;
     int[] min = new int[nums.length];
     int[] max = new int[nums.length];
     min[0] = max[0] = nums[0];
     
     for (int i = 1; i < nums.length; i++) {
         if (nums[i] > 0) {
            max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
            min[i] = Math.min(nums[i],  nums[i] * min[i - 1]);
         }else if (nums[i] < 0) {
             max[i] = Math.max(nums[i],  nums[i] * min[i - 1]);
             min[i] = Math.min(nums[i],  nums[i] * max[i - 1]);
         }
         result = Math.max(result, max[i]);
        }
    return result;
    }
}
