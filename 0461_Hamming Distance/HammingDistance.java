class Solution {
    public int hammingDistance(int x, int y) {
        int cnt = 0;
        int xor = x ^ y;
        while(xor > 0){
            cnt += (xor & 1);
            xor >>= 1;
        }
        return cnt;
    }
}