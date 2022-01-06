public class Solution {
    public void Rotate(int[] nums, int k) {
        var n = nums.Length;
        k %= n;
        Reverse(nums, 0, n-1);
        Reverse(nums, 0, k-1);
        Reverse(nums, k, n-1);
    }
    
    private void Reverse(int[] nums, int l , int r)
    {
        while(l < r)
        {
            var tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }
}