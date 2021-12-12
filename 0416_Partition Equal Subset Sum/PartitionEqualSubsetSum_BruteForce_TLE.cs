public class Solution {
    public bool CanPartition(int[] nums) {
        var sum = nums.Sum();
        if(sum % 2 != 0) return false;
        return Backtracking(nums, 0, sum / 2);
    }
    
    private bool Backtracking(int[] nums, int index, int sum)
    {
        if(index == nums.Length) return false;
        if(sum == 0) return true;
        if(sum < 0) return false;
        
        return Backtracking(nums, index+1, sum ) || Backtracking(nums, index+1, sum - nums[index]);
    }
}