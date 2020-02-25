/**
 * Find the last asceding element x, swap with the smallest number y, 
 * y is after x that and y is greater than x. Reverse the elements after x.
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = nums.length - 1;              // Start from the end
            while(nums[j] <= nums[i]) j--;           // Find rightmost first larger id j
            swap(nums, i, j);                     // Switch i and j
        }
        reverse(nums, i + 1, nums.length - 1);       // Reverse the descending sequence
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
