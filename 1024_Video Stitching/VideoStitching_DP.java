public class Solution {
    public int videoStitching(int[][] clips, int time) {
        int INF = 101;
        var dp = new int[time+1][time+1];
        for(int i=0;i<time+1;i++){
            for(int j=0;j<time+1;j++){
                dp[i][j] = INF;
            }
        }

        for(var k : clips){
            int s = k[0];
            int e = k[1];
            for(int len = 1;len <= time;len++){
                for(int l=0; l<= time-len;l++){
                    int r = l+len;
                    if(s > r || e < l) continue;
                    if(s <= l && e >= r) dp[l][r] = 1;
                    else if(e >= r){
                        dp[l][r] = Math.min(dp[l][r], dp[l][s] + 1);
                    }else if(s <= l){
                        dp[l][r] = Math.min(dp[l][r], 1 + dp[e][r]);
                    }else{
                        dp[l][r] = Math.min(dp[l][r], dp[l][s] + 1 + dp[e][r]);
                    }
                }
            }
        }
        
        return dp[0][time] == INF ? -1 : dp[0][time];
    }
}