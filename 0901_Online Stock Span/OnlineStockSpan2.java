class StockSpanner {
    private Stack<Integer> prices;
    private Stack<Integer> spans;
    public StockSpanner() {
      prices = new Stack<>();
      spans = new Stack<>();
    }
   
    public int next(int price) {
      int span = 1;
      while (!prices.empty() && price >= prices.peek()) {
        span += spans.pop();
        prices.pop();
      }
      prices.push(price);
      spans.push(span);
      return span;
    }
  }