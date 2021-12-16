public class Solution {
    public int MinimumTotal(IList<IList<int>> triangle) {
        var n = triangle.Count;
        if(n == 1) return triangle[0][0];
        
        for(int i=n-2;i>=0;i--)
        {
            var list = triangle[i];
            for(int j=0;j<list.Count;j++)
            {
                list[j] += Math.Min(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}