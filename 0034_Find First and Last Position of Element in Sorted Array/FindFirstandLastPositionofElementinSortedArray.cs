public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        var l = 0;
        var r = nums.Length;
        var ans = new int[2]{-1,-1};
        while(l < r)
        {
            var m = (r-l)/2 + l;
            if(nums[m] >= target)
                r = m;
            else
                l = m+1;
        }
        
        if(l >= 0 && l < nums.Length && nums[l] == target) ans[0] = l;
        else return ans;
        
        l = 0;
        r = nums.Length;
        while(l < r)
        {
            var m = (r-l)/2 + l;
            if(nums[m] > target)
                r = m;
            else
                l = m+1;
        }
        
        if(l-1 >= 0 && l-1 < nums.Length) ans[1] = l-1;
        
        return ans;
    }
}