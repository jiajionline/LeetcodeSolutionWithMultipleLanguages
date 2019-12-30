public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0;i<Integer.SIZE;i++){
            int tmp = n & 1;
            ans <<= 1;
            ans |= tmp;
            n >>= 1;
        }
        return ans;
    }
}