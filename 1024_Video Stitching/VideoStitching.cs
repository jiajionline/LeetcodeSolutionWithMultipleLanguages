public class Solution {
    public int VideoStitching(int[][] clips, int T) {
        int INF = 101;
        var dp = new int[T+1, T+1];
        for(int i=0;i<T+1;i++){
            for(int j=0;j<T+1;j++){
                dp[i,j] = INF;
            }
        }

        foreach(var k in clips){
            int s = k[0];
            int e = k[1];
            for(int l = 1;l<= T;l++){
                for(int i=0;i<= T-l;i++){
                    int j = i+l;
                    if(s > j || e < i) continue;
                    if(s <= i && e >= j) dp[i,j] = 1;
                    else if(e >= j){
                        dp[i,j] = Math.Min(dp[i,j], dp[i,s] + 1);
                    }else if(s <= i){
                        dp[i,j] = Math.Min(dp[i,j], 1 + dp[e,j]);
                    }else{
                        dp[i,j] = Math.Min(dp[i,j], dp[i,s] + 1 + dp[e,j]);
                    }
                }
            }
        }
        
        return dp[0,T] == INF ? -1 : dp[0,T];
    }
}