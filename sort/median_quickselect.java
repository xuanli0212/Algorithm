public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
  
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums[0];
        }
        //int k = (nums.length - 1) / 2 ;
        return helper(nums, 0, nums.length - 1, (nums.length - 1) / 2);
        
    }
    private int helper(int[] nums, int start, int end, int size) {
        //int mid = start + (end - start)/2;
        int pivot = nums[end];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[i] < pivot) {
                i++;
            }
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            swap(nums, i, j);
        }
        swap (nums, i, end);
        if (i == size) {
            return nums[i];
        } else if (i < size ) {
            return helper(nums, i + 1, end, size);
        } else {
            return helper(nums, start, i - 1, size);
        } 
        
        
    }
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}



