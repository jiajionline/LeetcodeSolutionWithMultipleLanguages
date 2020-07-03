public class Solution {
    public int[] FinalPrices(int[] prices) {
        var stack = new Stack<int>();

        for(int i=0;i<prices.Length;i++){
            while(stack.Count > 0 && prices[stack.Peek()] >= prices[i]){
                prices[stack.Peek()] -= prices[i];
                stack.Pop();
            }
            stack.Push(i);
        }
        return prices;
    }
}