public class MinStack {

	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.size() ==0 || minStack.peek() >= x){
        	minStack.push(x);
        }
    }
    
    public void pop() {
    	if(stack.isEmpty()) return;
        int v = stack.pop();
        if(v == minStack.peek()){
        	minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
