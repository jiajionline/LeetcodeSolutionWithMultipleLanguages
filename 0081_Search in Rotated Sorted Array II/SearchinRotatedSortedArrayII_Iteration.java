public class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = (r - l)/2 + l;
            if (nums[mid] == target)
                return true;
            
            if(nums[mid] == nums[r]){
                r--;
            }else if(nums[mid] == nums[l]){
                l++;
            }else if (nums[l] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[l]) 
                    r = mid - 1;
                 else
                    l = mid + 1;
            }else{
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                 else
                    r = mid - 1;
            }
        }
        return false;
    }
}