
class Solution {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {        
        int N = nums.length;
        if(N == 0) return 0;
        int MOD = (int)1e9 + 7;
        int[][] dp = new int[N+1][2];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, ans = 0;
        
        for(int i=1;i<=N;i++) {
            int num = nums[i-1];
            sum += (num == 1 ? 1 : -1);
            dp[i][0] = map.getOrDefault(sum, 0);
            if(num == 1){
                dp[i][1] = (dp[i-1][0] + dp[i-1][1] + 1) % MOD; 
            }else{
                dp[i][1] = (dp[i-1][1] - dp[i-1][0] + MOD) % MOD;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            ans = (ans + dp[i][1]) % MOD;
        }
        return ans;
    }
}