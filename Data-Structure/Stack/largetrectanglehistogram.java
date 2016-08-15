public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height.length == 0 || height == null) {
            return 0;
        }
        if (height.length == 1) {
            return height[0];
        }
        Stack<Integer> ascStack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int cur = i == height.length ? -1: height[i];
            if (ascStack.isEmpty() || cur > height[ascStack.peek()]) {
                ascStack.push(i);
            } else {
                while (!ascStack.isEmpty() && cur <= height[ascStack.peek()]) {
                        int hight = height[ascStack.pop()];
                        int width = ascStack.isEmpty()? i : i - ascStack.peek() - 1;
                        int area = hight * width;
                        max = Math.max(max, area);
                    }
                ascStack.push(i);
            }
        }
        return max;
    }
}
