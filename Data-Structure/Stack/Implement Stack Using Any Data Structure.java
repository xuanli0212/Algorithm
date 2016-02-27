class Stack {
    
    private List<Integer> stackArray = new ArrayList<Integer>();
    
    // Push a new item into the stack
    public void push(int x) {
        stackArray.add(x);
        // Write your code here
    }

    // Pop the top of the stack
    public void pop() {
        int size = stackArray.size();
        if(size  > 0 ){
            stackArray.remove(size-1);
        }
        return;
        // Write your code here
    }

    // Return the top of the stack
    public int top() {
        int size = stackArray.size();
        int topEle = stackArray.get(size-1);
        return topEle;
        // Write your code here
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        return stackArray.size() == 0 ;
        // Write your code here
    }    
}
