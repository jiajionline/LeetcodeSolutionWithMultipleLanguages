class Solution {
    private int sum = 0;
    public int numberOfArithmeticSlices(int[] nums) {
        slices(nums, nums.length - 1);
        return sum;
    }
    
    private int slices(int[] nums, int i) {
        if(i < 2) return 0;
        int count = 0;
        if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
            count = slices(nums, i-1) + 1;
            sum += count;
        }else {
            slices(nums, i-1);
        }
        
        return count;
    }
}
