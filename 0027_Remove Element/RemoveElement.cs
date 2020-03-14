public class Solution {
    public int RemoveElement(int[] nums, int val) {
        if(nums == null || nums.Length ==0) return 0;
        var s = 0;
        var e = 0;
        while(e < nums.Length){
            if(nums[e] != val){
                nums[s++] = nums[e];
            }
            
            e++;
        }
        
        return s;
    }
}