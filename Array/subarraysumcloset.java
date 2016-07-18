public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    class Pair {
        public int sum;
        public int index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] result = new int[2];
        if (nums == null || nums.length == 1) {
            return result;
        }
        if (nums.length == 1) {
            result[0] = nums[0];
            result[1] = nums[0];
            return result;
        }
        int length = nums.length;
        Pair[] prefixsum = new Pair[length + 1];
        int sum = 0;
        prefixsum[0] = new Pair(0, 0);
        for (int i = 1; i <= length; i++) {
            sum = sum + nums[i - 1];
            prefixsum[i] = new Pair(sum, i);
        }
        //sort the prefix sum value
        Comparator<Pair> sortArray = new Comparator<Pair>() {
            public int compare(Pair A, Pair B) {
               return A.sum - B.sum;
            }
        };
        Arrays.sort(prefixsum, sortArray);
        int diff = Integer.MAX_VALUE;
        int[] temp = new int[2];
        for (int i = 0; i < length; i++) {
            if (diff > prefixsum[i + 1].sum - prefixsum[i].sum) {
                diff = prefixsum[i + 1].sum - prefixsum[i].sum;
                temp[0] = prefixsum[i].index - 1;
                temp[1] = prefixsum[i + 1].index - 1;
            }
        }
        Arrays.sort(temp);
        result[0] = temp[0] + 1;
        result[1] = temp[1];
        return result;
    }
}
