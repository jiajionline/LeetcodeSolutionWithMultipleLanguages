class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curr = 0;
        int l = 0, r = 0;
        
        while(r < nums.length) {
            while(r < nums.length && nums[l] == nums[r]) r++;
            r--;
            
            nums[curr++] = nums[r];
            if(r > l) {
                nums[curr++] = nums[r];
            }
            
            r++;
            l = r;
            if(r == nums.length) break;
        }
        
        return curr;
    }
}