public class Solution {
    public int MinFlipsMonoIncr(string S) {
        var len = S.Length;
        var DP = new int[len+1,2];
        for(int i=1;i<=len;i++){
            if(S[i-1] == '0'){
                //from '0' to '0', no need to transition
                DP[i,0] = DP[i-1,0];
                //from '0' to '1' 
                DP[i,1] = Math.Min(DP[i-1,0], DP[i-1,1]) + 1;
            }else{
                //from '1' to '0'
                DP[i,0] = DP[i-1,0] + 1;
                //from '1' to '1'
                DP[i,1] = Math.Min(DP[i-1,0], DP[i-1,1]) ;            
            }
        }

        return Math.Min(DP[len,0], DP[len,1]);
    }
}