public class StockSpanner {
    // Tuple<price,freq>
    private Stack<Tuple<int,int>> stack;

    public StockSpanner() {
        stack = new Stack<Tuple<int,int>>();
    }
    
    public int Next(int price) {      
        var span = 1;
        while(stack.Count > 0 && price >= stack.Peek().Item1)
        {
            span += stack.Peek().Item2;
            stack.Pop();
        }

        stack.Push(Tuple.Create(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.Next(price);
 */