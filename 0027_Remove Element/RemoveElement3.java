class Solution {
    public int removeElement(int[] nums, int val) {
        int p1 = nums.length-1, p2 = nums.length-1;
        while(p1 >= 0) {
            if(nums[p1] == val) {
                swap(nums, p1--, p2--);
            }else{
                p1--;
            }
        }
        
        return p2 + 1;
    }
    
    private void swap(int[] nums, int p1, int p2) {
        int v = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = v;
    }
}