public class Solution {
    public int LargestRectangleArea(int[] heights) {
        var ans = 0;
        if(heights == null || heights.Length == 0) return ans;
        var l = new List<int>(heights.Length+1);
        foreach(var v in heights)
        {
            l.Add(v);
        }
        
        l.Add(0);
        
        var stack = new Stack<int>();
        
        var index = 0;
        while(index < l.Count)
        {
            if(!stack.Any() || l[index] >= l[stack.Peek()])
            {
                stack.Push(index++);
            }else{
                var h = l[stack.Peek()];
                stack.Pop();
                var w = !stack.Any() ? index : index - stack.Peek() - 1;
                ans = Math.Max(ans, h * w);
            }
        }
        
        return ans;
    }
}