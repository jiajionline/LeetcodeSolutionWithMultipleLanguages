class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int far = 0;
        int curr = 0;
        for(int i = 0;i<nums.length-1;i++) {
            if(far < nums[i] + i) {
                far = nums[i] + i;
            }
            
            if(curr == i) {
                count++;
                curr = far;
            }
        }
        
        return count;
    }
}