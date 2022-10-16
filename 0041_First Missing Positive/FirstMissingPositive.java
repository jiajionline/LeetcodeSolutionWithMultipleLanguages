class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                int t = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
            }
        }
        
        for(int i=0;i<n;i++) {
            if(nums[i] != i+1) return i+1; 
        }
        
        return n + 1;
    }
}