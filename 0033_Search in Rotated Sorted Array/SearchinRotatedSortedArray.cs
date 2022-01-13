public class Solution {
    public int Search(int[] nums, int target) {
        var l = 0;
        var r = nums.Length-1;
        
        while(l <= r)
        {
            var mid = (r-l)/2 + l;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[l])
            {
                if(target >= nums[l] && target < nums[mid])
                    r = mid-1;
                else
                    l = mid+1;
            }else{
                if(target > nums[mid] && target <= nums[r])
                    l = mid+1;
                else
                    r = mid-1;
            }
        }
        
        return -1;
    }
}