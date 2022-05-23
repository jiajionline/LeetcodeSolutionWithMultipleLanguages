class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    
    public int pop() {
        peek();
        return popStack.pop();
    }
    
    public int peek() {
        if(popStack.isEmpty()) {
            while(pushStack.size() > 0) {
                popStack.push(pushStack.pop());
            }
        }
        
        return popStack.peek();
    }
    
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}