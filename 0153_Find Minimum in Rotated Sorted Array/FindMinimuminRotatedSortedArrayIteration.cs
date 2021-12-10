public class Solution {
    public int FindMin(int[] nums) {
        var l = 0;
        var r = nums.Length-1;
        
        while(l < r)
        {
            var mid = (r-l)/2 + l;
            if(nums[mid] > nums[r])
            {
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        
        return nums[l];
    }
}