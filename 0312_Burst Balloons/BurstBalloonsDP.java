class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] vals = new int[n+2];
        vals[0] = vals[n+1] = 1;
        for(int i=0;i<n;i++){
            vals[i+1] = nums[i];
        }

        int[][] DP = new int[n+2][n+2];
        //length of sub balloons start from 1
        for(int len = 1;len <= n; len++){
            for(int l=1; l + len <= n+1;l++){
                int r = l + len - 1;
                int most = 0;
                for(int k = l; k<= r; k++){
                    most = Math.max(most, DP[l][k-1] + vals[l-1] * vals[k] * vals[r+1] + DP[k+1][r]);
                } 


                DP[l][r] = most;
            }
        }

        return DP[1][n];
    }
}
