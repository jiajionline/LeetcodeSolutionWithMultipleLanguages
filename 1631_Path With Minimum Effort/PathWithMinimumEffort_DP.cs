public class Solution {
    public int MinimumEffortPath(int[][] heights) {
        var rowLen = heights.Length;
        var colLen = heights[0].Length;
        
        // dp[i][j] is the minimum effort from (0,0) to (i,j)
        // scan the four neighbors of i,j, and get the max value between dp[nei] and heights[nei] - heights[i,j]
        // and the minimal value should be the answer.
        // dp[i][j] =  min(max(dp[nei,nei], heights[nei] - heights[i,j]))
        var dp = new int[rowLen,colLen];
        for(var i = 0;i<rowLen;i++)
           for(var j = 0;j<colLen;j++)
               dp[i,j] = int.MaxValue;
        
        dp[0,0] = 0;
        var dirs = new int[]{0,-1,0,1,0};
        for(var k = 0; k < rowLen * colLen; k++)
        {
            bool stable = true;
            for (var x = 0; x < rowLen; ++x)
                for (var y = 0; y < colLen; ++y)
                  for (int d = 0; d < 4; ++d) {
                    var tx = x + dirs[d];
                    var ty = y + dirs[d + 1];
                    //out of boundary 
                    if (tx < 0 || tx >= rowLen || ty < 0 || ty >= colLen) continue;
                    int t = Math.Max(dp[tx,ty], Math.Abs(heights[tx][ty] - heights[x][y]));
                    if (t < dp[x,y]) {
                      stable = false;
                      dp[x,y] = t;
                    }
                  }    
            if (stable) break;
        }
        
        return dp[rowLen-1, colLen-1];
    }
}