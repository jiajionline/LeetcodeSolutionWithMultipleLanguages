public class Solution {
    private Dictionary<int, List<int>> _dict;
    private Random _rand;
    public Solution(int[] nums) {
        _rand = new Random();
        _dict = new Dictionary<int, List<int>>();
        for(int i=0;i<nums.Length;i++)
        {
            if(!_dict.ContainsKey(nums[i])) _dict.Add(nums[i], new List<int>());
            _dict[nums[i]].Add(i);
        }
    }
    
    public int Pick(int target) {
        var list = _dict[target];
        return list[_rand.Next(0, list.Count)];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.Pick(target);
 */