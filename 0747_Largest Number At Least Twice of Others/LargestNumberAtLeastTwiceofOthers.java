class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length <=1 ) return 0;
        int secMax = 0;
        int max = 1;
        if(nums[1] < nums[0]) {
            max = 0;
            secMax = 1;
        }
        
        for(int i=2;i<nums.length;i++) {
            if(nums[i] > nums[max]) {
                secMax = max;
                max = i;
            }else if(nums[i] > nums[secMax]) {
                secMax = i;
            }
        }
        
        return nums[max] >= nums[secMax] * 2 ? max : -1;
    }
}