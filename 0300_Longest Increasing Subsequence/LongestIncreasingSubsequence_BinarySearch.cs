public class Solution {
    public int LengthOfLIS(int[] nums) {
        if(nums.Length == 1) return 1;
        var dp = new List<int>();
        for(int i=0;i<nums.Length;i++)
        {
            var pos = BinarySearch(dp,nums[i]);
            if(pos == dp.Count)
                dp.Add(nums[i]);
            else
                dp[pos] = nums[i];
        }
        
        return dp.Count();
    }
    
    private int BinarySearch(List<int> list, int target)
    {
        var l = 0;
        var r = list.Count;
        while(l < r)
        {
            var mid = (r-l)/2 + l;
            if(list[mid] >= target)
                r = mid;
            else
                l = mid+1;
        }
        
        return l;
    }
}