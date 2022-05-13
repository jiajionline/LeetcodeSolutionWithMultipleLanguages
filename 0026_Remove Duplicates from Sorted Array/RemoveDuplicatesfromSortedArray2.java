class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int v : nums) {
            if(i < 1 || v > nums[i-1])
                nums[i++] = v;
        }
        
        return i;
    }
}