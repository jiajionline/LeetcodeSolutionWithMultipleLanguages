public class Solution {
    public int SingleNonDuplicate(int[] nums) {
        
        var l = 0;
        var r = nums.Length-1;
        
        while(l <= r)
        {
            var m = (r - l)/2 + l;
            var n = (m % 2 == 0 ? m+1 : m-1);
            if(n >= nums.Length || n < 0) return nums[m];
            if(nums[m] == nums[n])
            {
                l = m+1;
            }else{
                r = m-1;
            }
        }
        
        return nums[l];
    }
}