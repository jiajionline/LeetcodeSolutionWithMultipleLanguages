class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1,-1};
        if(nums == null || nums.length ==0) return ret;
        
        int l = 0;
        int r = nums.length;
        
        while(l < r){
            int m = l + (r - l)/2;
            if(nums[m]>=target){
                r = m;
            }else{
                l = m+1;
            }
        }
        
        if(l >=0 && l < nums.length && nums[l] == target){
            ret[0] = l;
        }
        
        l = 0;
        r = nums.length;
        
        while(l < r){
            int m = l + (r - l)/2;
            if(nums[m]>target){
                r = m;
            }else{
                l = m+1;
            }
        }
        
        if(l > 0 && nums[l-1] == target){
            ret[1] = l-1;
        }
        
        return ret;
    }
}