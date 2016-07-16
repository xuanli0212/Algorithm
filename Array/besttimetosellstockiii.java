class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] left = new int[prices.length];
        int leftmin = prices[0];
        int[] right = new int[prices.length];
        int rightmax = prices[prices.length - 1];
        //from left to right
        left[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i - 1],prices[i] - leftmin);
            leftmin = Math.min(leftmin, prices[i]);
        }
        //from right to left
        right[prices.length - 1] = 0;
        for (int i = prices.length -2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], rightmax - prices[i]);
            rightmax = Math.max(rightmax, prices[i]);
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max,left[i] + right[i]);
        }
        return max;
    }
};
