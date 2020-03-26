public class Solution {
    public int singleNumber(int[] A) {
        int ans = 0;
        for(int i=0;i<32;i++){
            int bit = 0;
            for(int j=0;j<A.length;j++){
                bit += ((A[j]>>i) & 1);
            }            
            ans += ((bit % 3) << i );
        }        
        return ans;
    }
}