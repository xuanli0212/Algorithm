class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int pivot = 0; pivot <= 2; pivot++) {
            int i = 0;
            int j = nums.length - 1;
            while (i <= j) {
                while (i <= j && nums[i] <= pivot) {
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
        }
    }
}
