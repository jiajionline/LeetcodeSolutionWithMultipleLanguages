class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        
        int l = 0;
        
        while(l < nums.length) {
            if(nums[l] == clone[l]) l++;
            else break;
        }
        
        if(l == nums.length) return 0;
        
        int r = nums.length - 1;
        
        while(r > l) {
            if(nums[r] == clone[r]) r--;
            else break;
        }
        
        return r - l + 1;
    }
}