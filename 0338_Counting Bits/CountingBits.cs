public class Solution {
    public int[] CountBits(int n) {
        var ans = new int[n+1];
        
        for(int i=0;i<=n;i++)
        {
            var count1s = 0;
            var j = i;
            while(j >0)
            {
                if((j & 1) == 1){
                    count1s++;
                }
                
                
                 j >>= 1;
            }
            ans[i] = count1s;
        }
        
        return ans;
    }
}