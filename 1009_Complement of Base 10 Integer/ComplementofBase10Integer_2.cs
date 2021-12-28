public class Solution {
    public int BitwiseComplement(int n) {
        var k = 1;
        while(k < n)
        {
            k <<= 1;
            k++;
        }
        
        return k - n;
    }
}