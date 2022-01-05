public class Solution {
    public int[] SingleNumber(int[] nums) {
        var r = 0;
        foreach(var n in nums)
            r ^= n;
        
        var k = 1;
        for(int i=0;i<32;i++)
        {
            if((k & r) > 0)
                break;
            else
                k <<= 1;
        }
        
        var ans = new int[2];
        foreach(var n in nums)
        {
            if((n & k) > 0)
                ans[0] ^= n;
            else
                ans[1] ^= n;
        }
        
        return ans;
    }
}