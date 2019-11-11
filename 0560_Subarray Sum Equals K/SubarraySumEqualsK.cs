public class Solution {
    public int SubarraySum(int[] nums, int k) {
        if(nums == null || nums.Length == 0) return 0;
        var ans = 0;
        var dict = new Dictionary<int,int>();
        dict.Add(0,1);
        var sum = 0;
        foreach (var v in nums)
        {
            sum += v;
            if(dict.ContainsKey(sum-k))
            {
                ans += dict[sum-k];
            }

            if(!dict.ContainsKey(sum)) dict.Add(sum,0);
            dict[sum] += 1;
        }
        return ans;
    }
}