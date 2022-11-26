class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++) {
            while(nums[i] < n && nums[i] != i) {
                int v = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = v;
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i] != i) return i;
        }
        
        return n;
    }
}