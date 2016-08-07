public class MinStack {
    Stack<Integer> holder;
    Stack<Integer> minHolder;
    
    public MinStack() {
        // do initialize if necessary
        holder = new Stack<Integer>();
        minHolder = new Stack<Integer>();
        
    }

    public void push(int number) {
        // write your code here
        holder.push(number);
        if (minHolder.isEmpty()) {
            minHolder.push(number);
        } else {
            minHolder.push(Math.min(minHolder.peek(),number));
        }
    }

    public int pop() {
        // write your code here
        int val = holder.pop();
        minHolder.pop();
        return val;
        
    }

    public int min() {
        // write your code here
        return minHolder.peek();
    }
}
