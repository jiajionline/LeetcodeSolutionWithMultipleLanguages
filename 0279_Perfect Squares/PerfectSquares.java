class Solution {
    public int numSquares(int n) {
        int[] DP = new int[n+1];
        Arrays.fill(DP,Integer.MAX_VALUE);
        DP[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                DP[i] = Math.min(DP[i], DP[i-j*j]+1);
            }
        }

        return DP[n];
    }
}