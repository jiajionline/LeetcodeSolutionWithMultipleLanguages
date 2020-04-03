public class MyStack {

	private Queue<Integer> current = new LinkedList<Integer>();
	private Queue<Integer> backup = new LinkedList<Integer>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.current.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        this.adjust();
        return this.current.poll();
        
    }
    
    /** Get the top element. */
    public int top() {
        this.adjust();
        return this.current.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.current.isEmpty() && this.backup.isEmpty();
    }
    
    private void adjust(){
    	if(this.empty()) return;
    	if(this.current.isEmpty()){
    		Queue<Integer> temp = this.current;
    		this.current = this.backup;
    		this.backup = temp;
    	}
    	
    	while(this.current.size() > 1){
    		this.backup.add(this.current.poll());
    	}
    }
}
