public class Solution {
    public int RemoveDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.Length < 2 ) return nums.Length;
        
        int currIndex = 1;
        
        for(int i=1;i<nums.Length;i++){
            if(nums[i-1] != nums[i]){
                nums[currIndex++] = nums[i];
            }
        }
        
        return currIndex;
    }
}