public class Solution {
    public bool PredictTheWinner(int[] nums) {
        return GetScores(nums,0, nums.Length-1) >= 0;
    }
    
    private int GetScores(int[] nums, int l, int r)
    {
        if(l == r) return nums[l];
        else{
            return Math.Max((nums[l] - GetScores(nums,l+1,r)), (nums[r] - GetScores(nums,l,r-1)));
        }
    }
}