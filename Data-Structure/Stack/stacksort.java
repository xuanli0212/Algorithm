public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        Stack<Integer> tmp = new Stack<Integer>();
        while (!stack.isEmpty()) {
            if (stack.isEmpty() || (tmp.isEmpty() || tmp.peek() >= stack.peek())) {
               tmp.push(stack.pop());
            } else {
                int cur = stack.pop();
                while (!tmp.isEmpty() && tmp.peek() <= cur) {
                    stack.push(tmp.pop());
                }
                tmp.push(cur);
            }
        }
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }
   
}
