public class Solution {
    public bool PredictTheWinner(int[] nums) {
        return GetScores(nums,0, nums.Length-1, new Dictionary<string,int>()) >= 0;
    }
    
    private int GetScores(int[] nums, int l, int r, Dictionary<string,int> dict)
    {
        if(l == r) return nums[l];
        var key = l + "_" + r;
        if(dict.ContainsKey(key)) return dict[key];

        var v = Math.Max((nums[l] - GetScores(nums,l+1,r,dict)), (nums[r] - GetScores(nums,l,r-1,dict)));
        dict.Add(key,v);
        return v;
    }
}