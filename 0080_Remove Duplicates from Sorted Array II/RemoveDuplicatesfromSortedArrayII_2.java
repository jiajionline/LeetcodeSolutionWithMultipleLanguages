class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;
        while(r < nums.length)
        {
            int curr = nums[r];
            int count = 0;
            while(r < nums.length && nums[r] == curr)
            {
                count++;
                r++;
            }
            
            for(int i=1;i<=Math.min(2, count);i++)
                nums[l++] = curr;
        }
        
        return l;
    }
}