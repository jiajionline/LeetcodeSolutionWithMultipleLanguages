class MaxStack {
    private Stack<int[]> stack;
    private PriorityQueue<int[]> pq;
    private Set<Integer> removed;
    private int count = 0;

    public MaxStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<int[]>((a,b) ->  a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0]));
        removed = new HashSet<>();
    }
    
    public void push(int x) {
        stack.push(new int[]{x, count});
        pq.offer(new int[]{x, count});
        count++;
    }
    
    public int pop() {
        while(removed.contains(stack.peek()[1])) stack.pop();
        int[] item = stack.pop();
        removed.add(item[1]);
        return item[0];
    }
    
    public int top() {
        while(removed.contains(stack.peek()[1])) stack.pop();
        return stack.peek()[0];
    }
    
    public int peekMax() {
        while(removed.contains(pq.peek()[1])) pq.poll();
        return pq.peek()[0];
    }
    
    public int popMax() {
        while(removed.contains(pq.peek()[1])) pq.poll();
        int[] item = pq.poll();
        removed.add(item[1]);
        return item[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */