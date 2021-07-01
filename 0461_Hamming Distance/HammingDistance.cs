public class Solution {
    public int HammingDistance(int x, int y) {
        var ans = 0;
        if(x == y) return ans;
        while(x > 0 || y > 0)
        {
            if((x & 1) != (y & 1)) ans++;
            x = x >> 1;
            y = y >> 1;
        }
        
        return ans;
    }
}