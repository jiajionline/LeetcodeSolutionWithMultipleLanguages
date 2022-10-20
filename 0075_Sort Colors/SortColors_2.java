class Solution {
    public void sortColors(int[] nums) {
        int cOf0 = 0, cOf1 = 0, cOf2 = 0;
        for(int v : nums) {
            if(v == 0) cOf0++;
            if(v == 1) cOf1++;
            if(v == 2) cOf2++;
        }
        
        int index = 0;
        while(cOf0-- > 0) nums[index++] = 0;
        while(cOf1-- > 0) nums[index++] = 1;
        while(cOf2-- > 0) nums[index++] = 2;
    }
}