public class Solution {
    public int[] SortedSquares(int[] nums) {
        var n = nums.Length;
        var ans = new int[n];
        var s = 0;
        var e = n - 1;
        for(int k=n-1;k>=0;k--){
            if(Math.Abs(nums[s]) > Math.Abs(nums[e]))
            {
                ans[k] = nums[s] * nums[s];
                s++;
            }else{
                ans[k] = nums[e] * nums[e];
                e--;
            }
        }
        
        return ans;
    }
}