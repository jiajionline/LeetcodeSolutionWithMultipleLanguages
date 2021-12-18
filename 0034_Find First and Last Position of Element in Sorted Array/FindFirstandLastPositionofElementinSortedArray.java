class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        if(nums == null || nums.length ==0) return ans;
        
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
            ans[0] = l;
        }else return ans;
        
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
        
        if(l-1 >= 0 && l-1 < nums.length){
            ans[1] = l-1;
        }
        
        return ans;
    }
}