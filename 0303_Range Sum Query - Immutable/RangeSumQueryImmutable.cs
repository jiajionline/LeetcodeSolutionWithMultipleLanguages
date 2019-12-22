public class NumArray {
    private int[] dp;
    public NumArray(int[] nums) {
        if(nums == null || nums.Length == 0) return;
        dp = new int[nums.Length];
        for(int i=0;i<nums.Length;i++)
        {
            if(i==0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1] + nums[i];
            }
        }
    }
    
    public int SumRange(int i, int j) {
        if(dp == null) return 0;
        if(i==0) return dp[j];
        else return dp[j] - dp[i-1];
    }
}