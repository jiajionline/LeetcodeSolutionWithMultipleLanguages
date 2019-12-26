class Solution {
    public int maximumProduct(int[] nums) {
        if(nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length-1], nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3]);
    }
}