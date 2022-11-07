class MinStack {
    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int[] arr = new int[]{val, val};
        if(!stack.isEmpty()){
            int[] prev = stack.peek();
            if(prev[1] < arr[1]) arr[1] = prev[1];
        }
        stack.push(arr);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        int[] arr = stack.peek();
        return arr[0];
    }
    
    public int getMin() {
        int[] arr = stack.peek();
        return arr[1];
    }
}