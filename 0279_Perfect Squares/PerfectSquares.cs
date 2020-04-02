public class Solution {
    public int NumSquares(int n) {
        var DP = Enumerable.Repeat(int.MaxValue, n + 1).ToArray();
        DP[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                DP[i] = Math.Min(DP[i],DP[i-j*j] + 1);
            }
        }
        return DP[n];
    }
}