class Solution {
    public int bitwiseComplement(int N) {
        int ans = 1;
        while(ans < N){
            ans <<= 1;
            ans +=1;
        }

        return ans - N;
    }
}