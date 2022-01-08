public class Solution {
    public int MaxScoreSightseeingPair(int[] values) {
        var currMax = values[0];
        var ans = 0;
        
        for(int j=1;j<values.Length;j++)
        {
            ans = Math.Max(ans, currMax + values[j] - j);
            currMax = Math.Max(currMax, values[j] + j);
        }
        
        return ans;
    }
}