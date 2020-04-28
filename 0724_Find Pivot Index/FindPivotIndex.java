class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length <=2) return -1;
        int lCount = 0;
        int rCount = 0;
        for(int v : nums) rCount += v;

        for(int i=0;i<nums.length;i++){
            rCount -= nums[i];
            if(lCount == rCount) return i;
            lCount += nums[i];
        }

        return -1;
    }
}