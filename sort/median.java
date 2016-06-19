public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return 0;
        }
        int l = nums.length;
        quicksort(nums, 0, l-1);
        int median = (l-1)/2;
        return nums[median];
    }
    private void quicksort(int[] nums, int left, int right){
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int pivot = nums[left + (right - left)/2] ;
        while (i <= j){
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        quicksort(nums, left, j);
        quicksort(nums, i, right);
    }
}
