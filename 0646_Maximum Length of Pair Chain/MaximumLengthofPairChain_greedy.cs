public class Solution {
    public int FindLongestChain(int[][] pairs) {
        Array.Sort(pairs, (a,b) => a[1].CompareTo(b[1]));
        var end = int.MinValue;
        var ans = 0;
        
        for(int i=0;i< pairs.Length;i++)
        {
            if(pairs[i][0] > end)
            {
                end = pairs[i][1];
                ans++;
            }
        }
        
        return ans;
    }
}