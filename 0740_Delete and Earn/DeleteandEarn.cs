public class Solution {
    public int DeleteAndEarn(int[] nums) {
        if(nums == null || nums.Length == 0) return 0;
      
        var max = nums.Max();
        var sum = new int[max+1];
        
        for(int i=0;i<nums.Length;i++){
            sum[nums[i]]+= nums[i];
        }
        
        for(int i = 2; i < sum.Length; i++){
            sum[i] = Math.Max(sum[i-1], sum[i-2] + sum[i]);
        }
        
        return sum[sum.Length-1];
    }
}