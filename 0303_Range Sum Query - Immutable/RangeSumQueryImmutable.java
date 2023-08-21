class NumArray {
    private int[] presum;

    public NumArray(int[] nums) {
        presum = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i == 0){
                presum[i] = nums[i];
            }else{
                presum[i] = presum[i-1] + nums[i];
            }
        }
    }
    
    public int sumRange(int left, int right) {
        return presum[right] - (left -1 >= 0 ? presum[left-1] : 0);
    }
}