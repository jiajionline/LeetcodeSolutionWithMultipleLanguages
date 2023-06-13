class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0, p1 = 0 , p2 = 0;
        while(p2 < nums.length) {
            while(p2 < nums.length && nums[p2] == nums[p1]) p2++;
            int c = Math.min(2, p2 - p1);
            for(int i=0;i<c;i++) {
                nums[p++] = nums[p1];
            }
            
            p1 = p2;
        }
        
        return p;
    }
}