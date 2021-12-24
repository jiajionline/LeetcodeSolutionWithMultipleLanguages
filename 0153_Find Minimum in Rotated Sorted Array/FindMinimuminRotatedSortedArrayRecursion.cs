public class Solution {
    public int FindMin(int[] nums) {
        return FindMin(nums,0, nums.Length-1);
    }
    
    private int FindMin(int[] nums, int l , int r)
    {
        if(l+1 >= r) return Math.Min(nums[l],nums[r]);
        if(nums[l] < nums[r]) return nums[l];
        var mid = (r - l)/2 + l;
        return Math.Min(FindMin(nums, l, mid), FindMin(nums, mid+1,r));
    }
}