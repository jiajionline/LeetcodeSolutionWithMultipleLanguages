public class Solution {
    public int MaximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.Length == 0) return 0;
        var ans = 0;
        var rows = matrix.Length;
        var cols = matrix[0].Length;
        var heights = new int[cols];

        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }else{
                    heights[j] += 1;
                }
            }
            
            ans = Math.Max(ans, LargestRectangleArea(heights));
        }
        
        return ans;
        
    }
    
    private int LargestRectangleArea(int[] heights) {
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