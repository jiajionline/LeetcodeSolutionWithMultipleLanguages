class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int len = 3;len<= n;len++) {
            for(int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                boolean isConsecutive = true;
                int v = nums[r] - nums[r-1];
                for(int k = r-1; k>l;k--) {
                    if(nums[k] - nums[k-1] != v) {
                         isConsecutive = false;
                        break;
                    }
                }
                
                if(isConsecutive) ans++;
            }
        }
        
        return ans;
    }
}