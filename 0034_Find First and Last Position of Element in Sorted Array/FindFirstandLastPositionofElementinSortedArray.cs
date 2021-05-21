public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        
        var ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        
        if(nums == null || nums.Length < 1) return ans;
        
        var l = 0;
        var r = nums.Length -1;
        
        while(l <=r){
            var m = (r-l)/2 + l;
            if(nums[m]>=target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        
        if(l>=0 && l < nums.Length && nums[l] == target){
                   ans[0] = l; 
        }
        
        
        l = 0;
        r = nums.Length -1;
        
        while(l <=r){
            var m = (r-l)/2 + l;
            if(nums[m]>target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        
        if(l > 0 && nums[l-1] == target)
        ans[1] = l-1;
        
        return ans;
    }
}