class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        quicksort(nums, 0, nums.length - 1);
        for (int i = 0; i < k && i < nums.length; i++) {
            resultList.add(nums[i]);
        }
        Collections.sort(resultList, Collections.reverseOrder());
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
   }
    private void quicksort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        quicksort(nums, start, right);
        quicksort(nums, left, end);
    }
};

