public class MyQueue {
    
	private Stack<Integer> enqueueStack = new Stack<Integer>();
	private Stack<Integer> dequeueStack = new Stack<Integer>();
	
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.enqueueStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        this.adjust();
        return this.dequeueStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        this.adjust();
        return this.dequeueStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.enqueueStack.isEmpty() && this.dequeueStack.isEmpty();
    }
    
    private void adjust(){
    	if(this.dequeueStack.isEmpty()){
    		while(this.enqueueStack.size() > 0){
    			this.dequeueStack.push(this.enqueueStack.pop());
    		}
    	}
    }
}
