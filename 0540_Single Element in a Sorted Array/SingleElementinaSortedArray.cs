public class Solution {
    public int SingleNonDuplicate(int[] nums) {
        
        var l = 0;
        var r = nums.Length;
        
        while(l < r)
        {
            var m = (r - l)/2 + l;
            if(m <= 0 || m+1 >= nums.Length) return nums[m];
            var n = (m % 2 == 0 ? m+1 : m-1);
            if(nums[m] == nums[n])
            {
                l = m+1;
            }else{
                r = m;
            }
        }
        
        return nums[l];
    }
}