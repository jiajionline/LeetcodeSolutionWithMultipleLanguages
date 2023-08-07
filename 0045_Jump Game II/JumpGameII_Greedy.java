class Solution {
    public int jump(int[] nums) {
        int curr = 0, far = 0, steps = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(far < nums[i] + i){
                far = nums[i] + i;
            }

            if(curr == i){
                steps++;
                curr = far;
            }
        }
        return steps;
    }
}