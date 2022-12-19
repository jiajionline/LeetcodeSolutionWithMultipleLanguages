class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        if((n & (n-1)) == 0){
            for(int i=0;i<32;i++){
                if(((n >> i) & 1) == 1){
                    return i % 2 == 0;
                }
            }
        }
        return false;
    }
}