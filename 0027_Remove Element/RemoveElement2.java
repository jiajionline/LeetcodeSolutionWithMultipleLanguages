class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        
        int s = 0;
        int e = nums.length - 1;
        
        while(s < e)
        {
            if(nums[s] == val) {
                int tmp = nums[s];
                nums[s] = nums[e];
                nums[e--] = tmp;
            }else{
                s++;
            }
        }
        
        return nums[s] == val ? s : s+1;
    }
}