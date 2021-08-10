public class Solution {
    public int LongestConsecutive(int[] nums) {
        if(nums == null || nums.Length == 0) return 0;
        var set = new HashSet<int>();
        foreach(var n in nums){
            set.Add(n);
        }
        
        var ans = 0;
        
        for(int i=0;i<nums.Length;i++)
        {
            if(!set.Contains(nums[i] - 1))
            {
                var tmpMax = 0;
                var v = nums[i];
                while(set.Contains(v))
                {
                    tmpMax++;
                    v++;
                }
                
                ans = Math.Max(ans, tmpMax);
            }
        }
        
        return ans;
    }
}