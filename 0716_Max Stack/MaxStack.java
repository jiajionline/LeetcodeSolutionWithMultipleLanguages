class MaxStack {
    private Stack<Pair> _stack;

    public MaxStack() {
        _stack = new Stack<Pair>();
    }
    
    public void push(int x) {
        int currMax = x;
        if(_stack.size() > 0 && _stack.peek().Max > currMax)
        {
            currMax = _stack.peek().Max;
        }
        
        Pair p = new Pair();
        p.Value = x;
        p.Max = currMax;
        _stack.add(p);
    }
    
    public int pop() {
        Pair p = _stack.pop();
        return p.Value;
    }
    
    public int top() {
        return _stack.peek().Value;
    }
    
    public int peekMax() {
        return _stack.peek().Max;
    }
    
    public int popMax() {
        Stack<Integer> _tmpStack = new Stack<Integer>();
        while(_stack.size() > 0 && _stack.peek().Value != _stack.peek().Max)
        {
            _tmpStack.add(_stack.peek().Value);
            _stack.pop();
        }
        
        var max = pop();
        
        while(_tmpStack.size() > 0)
        {
            push(_tmpStack.pop());
        }
        
        return max;
            
    }
}

public class Pair {
    public int Value;
    public int Max;
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