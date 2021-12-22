public class Solution {
    public int[] DailyTemperatures(int[] temperatures) {
        var n = temperatures.Length;
        var ans = new int[n];
        if(n == 0) return ans;
        
        var stack = new Stack<int>();
        
        for(int i=temperatures.Length-1;i>=0;i--)
        {
            while(stack.Count > 0 && temperatures[stack.Peek()] <= temperatures[i]) 
                stack.Pop();
            
            if(stack.Count > 0)
                ans[i] = stack.Peek() - i;  
            
             stack.Push(i);
        }
        
        return ans;
    }
}