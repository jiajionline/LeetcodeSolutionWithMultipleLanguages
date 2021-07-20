public class Solution {
    public int HammingWeight(uint n) {
        var ans = 0;
        while(n > 0)
        {
            if((1 & n) == 1) ans++;
            n = (n >> 1);
        }
        
        return ans;
    }
}