 class Solution {
   public void rotate(int[] nums, int k) {		
        int n = nums.length;
        k = k % n;
        if(k <= 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
	}
	    
    private void reverse(int[] nums, int l, int r){
        while(l < r){
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
            
        }
    }
}
