class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }
        
        return ans;
    }
}