public class Solution {
    public int FindMin(int[] nums) {
        var l = 0;
        var r = nums.Length - 1;
        
        while(l < r)
        {
            var mid = (r-l)/2 + l;
            if(nums[mid] > nums[r])
                l = mid + 1;
            else if(nums[mid] < nums[r])
                r = mid;
            else // when num[mid] and num[r] are same
                r--;
        }
        
        return nums[l];
    }
}