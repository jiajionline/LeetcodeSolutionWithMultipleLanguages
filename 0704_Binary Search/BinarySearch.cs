public class Solution {
    public int Search(int[] nums, int target) {
        var l = 0;
        var r = nums.Length;
        
        while(l < r)
        {
            var mid = (r-l)/2 + l;
            if(nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        
        if(l >= 0 && l < nums.Length && nums[l] == target) return l;
        else return -1;
    }
}