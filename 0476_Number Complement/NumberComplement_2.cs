public class Solution {
    public int FindComplement(int num) {
        var copy = num;
        var k = 1;
        while(copy > 0)
        {
            num ^= k;
            k <<= 1;
            copy >>= 1;
        }
        
        return num;
    }
}