public class Solution {
    //[l,r]
    public int SearchInsert(int[] nums, int target) {
        var l = 0;
        var r = nums.Length -1;
        
        while(l <= r){
            var m = (r-l)/2 + l;
            if(nums[m]>= target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        
        return l;
    }
}