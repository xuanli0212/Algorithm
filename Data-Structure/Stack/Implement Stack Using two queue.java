class Stack {
   
    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer> queue2 = new LinkedList<Integer>();
    
    public void push(int x) {
        queue1.offer(x);
        // Write your code here
    }

    // Pop the top of the stack
    public void pop() {
       while(queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Return the top of the stack
    public int top() {
        while(queue1.size() > 1){
                queue2.offer(queue1.poll());
        }
        int item = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        queue1.offer(item);
        return item;
        
        // Write your code here
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        return queue1.size() ==0;
        // Write your code here
    }    
}
