public class Solution {
    public int LengthOfLIS(int[] nums) {
        if(nums == null || nums.Length == 0) return 0;
        if(nums.Length == 1) return 1;
        var dict = new Dictionary<int,int>();
        dict[0] = 1;
        
        var ans = 1;
        for(int i=0;i<nums.Length;i++){
            ans = Math.Max(ans,LengthOfLIS(nums, i, dict));
        }
        
        return ans;
    }
    
    private int LengthOfLIS(int[] nums, int index, Dictionary<int,int> dict)
    {
        if(dict.ContainsKey(index)) return dict[index];
        var v = 1;
        for(int i=0;i<index;i++)
        {
            if(nums[index] > nums[i]){
                v = Math.Max(v, LengthOfLIS(nums, i, dict) + 1);
            }
        }
        
        dict[index] = v;
        return v;
    }
}