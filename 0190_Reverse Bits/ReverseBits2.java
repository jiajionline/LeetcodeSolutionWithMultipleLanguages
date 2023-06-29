public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int v = 0;
        for(int i=0;i<32;i++) {
            v = ( v << 1);
            v += (n & 1);
            n = ( n >> 1);
        }

        return v;
    }
}