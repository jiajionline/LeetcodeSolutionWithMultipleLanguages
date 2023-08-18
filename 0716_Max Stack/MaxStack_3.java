class MaxStack {
    private TreeSet<int[]> stack;
    private TreeSet<int[]> values; 
    private int count = 0;

    public MaxStack() {
        Comparator<int[]> comp = (a,b) ->  {
            return a[0] == b[0] ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]);
        };
        stack = new TreeSet<int[]>(comp);
        values = new TreeSet<int[]>(comp);
    }
    
    public void push(int x) {
        stack.add(new int[]{count,x});
        values.add(new int[]{x, count});
        count++;
    }
    
    public int pop() {
        int[] item = stack.pollLast();
        values.remove(new int[]{item[1], item[0]});
        return item[1];
    }
    
    public int top() {
        int[] item = stack.last();
        return item[1];
    }
    
    public int peekMax() {
        int[] item = values.last();
        return item[0];
    }
    
    public int popMax() {
        int[] item = values.pollLast();
        stack.remove(new int[]{item[1], item[0]});
        return item[0];
    }
}