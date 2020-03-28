class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i = 0;
        for(int v : nums){
            if(i < 2 || v > nums[i-2]){
                nums[i++] = v;
            }
        }
        
        return i;
    }
}