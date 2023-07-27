class Solution {
    public boolean increasingTriplet(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j] > nums[i]) {
                    for(int k=j+1;k<nums.length;k++) {
                        if(nums[k] > nums[j]) return true;
                    }
                }
            }
        }

        return false;
    }
}