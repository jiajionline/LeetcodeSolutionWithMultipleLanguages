public class Solution {
    public void Rotate(int[] nums, int k) {
        var n = nums.Length;
        k %= n;
        
        for(int t = 1;t<=k;t++)
        {
            var last = nums[n-1];
            for(int i=n-1;i>0;i--)
            {
                nums[i] = nums[i-1];
            }
            
            nums[0] = last;
        }
        
    }
}