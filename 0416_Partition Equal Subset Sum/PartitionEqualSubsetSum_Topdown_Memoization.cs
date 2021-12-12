public class Solution {
    public bool CanPartition(int[] nums) {
        var sum = nums.Sum();
        if(sum % 2 != 0) return false;
        var n = nums.Length;
        // 0 means hasn't computed yet, 1 means false, 2 means true
        var memo = new int[n+1, sum/2 + 1];
        
        return Backtracking(nums, 0, sum / 2, memo) == 2;
    }
    
    // returns 1 means false, 2 means true,
    private int Backtracking(int[] nums, int index, int sum, int[,] memo)
    {
        if(index == nums.Length) return 1;
        if(sum == 0) return 2;
        if(sum < 0) return 1;
        
        if(memo[index, sum] > 0) return memo[index, sum];
        
        var result = Backtracking(nums, index+1, sum, memo );
        if(result == 2)
        {
            memo[index, sum] = result;
            return result;
        }
        
        result = Backtracking(nums, index+1, sum - nums[index], memo);
        memo[index, sum] = result;
        return result;
    }
}