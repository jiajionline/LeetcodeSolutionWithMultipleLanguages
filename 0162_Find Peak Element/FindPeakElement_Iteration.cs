public class Solution {
    public int FindPeakElement(int[] nums) {
        var l = 0;
        var r = nums.Length -1;
        while(l < r){
            var m = (r-l)/2 + l;
            // Find the first m which num[m] > num[m + 1]
            if(nums[m] > nums[m+1]){
                r = m;
            }else{
                l = m+1;
            }
        }
        
        return l;
    }
}