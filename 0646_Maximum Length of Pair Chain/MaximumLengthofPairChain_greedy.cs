public class Solution {
    public int FindLongestChain(int[][] pairs) {
        if(pairs.Length == 0) return 0;
        
        Array.Sort(pairs, (a,b) => {
            if(a[1] < b[1]) return -1;
            else if(a[1] == b[1]) return 0;
            else return 1;
        });
       
        var ans = 1;
        var currEnd = pairs[0][1];
        
        for(int i=1;i<pairs.Length;i++)
        {
            if(currEnd < pairs[i][0])
            {
                ans++;   
                currEnd = pairs[i][1];
            }
        }
        
        return ans;
    }
}