public class Solution {
    public int BitwiseComplement(int N) {
        if(N == 0) return 1;
        int mask = ~0;
        while((N & mask) > 0) mask <<= 1;
        return ~N ^ mask;
    }
}