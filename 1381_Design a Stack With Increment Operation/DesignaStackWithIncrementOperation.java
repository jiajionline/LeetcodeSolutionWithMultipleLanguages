class CustomStack {
    private int[] stack;
    private int p;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        p = -1;
    }
    
    public void push(int x) {
        if(p + 1 < stack.length) {
            stack[++p] = x;
        }
    }
    
    public int pop() {
        if(p == -1) return -1;
        return stack[p--];
    }
    
    public void increment(int k, int val) {
        if(p == -1) return;
        for(int i=0;i<= Math.min(p, k-1); i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */