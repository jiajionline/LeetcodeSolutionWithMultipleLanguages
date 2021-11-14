public class Solution {
    public int MaxChunksToSorted(int[] arr) {
        var ans = 0;
        var max = 0;
        
        for(int i=0;i<arr.Length;i++)
        {
            max = Math.Max(arr[i], max);
            if(max == i) ans++;
        }
        
        return ans;
    }
}