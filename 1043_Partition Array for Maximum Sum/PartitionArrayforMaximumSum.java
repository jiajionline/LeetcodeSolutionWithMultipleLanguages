class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;
        int[] dp = new int[arr.length];
        
        for(int i=0;i<arr.length;i++) {
            int currMax = 0;
            for(int j = 1;j<= k && (i-j+1) >= 0;j++) {
                currMax = Math.max(currMax, arr[i-j+1]);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i-j] : 0) +  currMax * j );
            }
        }
        
        return dp[arr.length-1];
    }
}