class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }
    
    private int atMostK(int[] nums, int k) {
        int count = 0, left = 0, ans = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] % 2 == 1) count++;
            while(count > k) {
                if(nums[left++] % 2 == 1) count--;
            }
            
            ans += i - left + 1;
        }
        
        return ans;
    }
}