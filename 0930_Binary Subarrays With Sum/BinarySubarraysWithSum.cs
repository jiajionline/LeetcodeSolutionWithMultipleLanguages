public class Solution {
    public int NumSubarraysWithSum(int[] nums, int goal) {
        //presum, occurrence 
        var dict = new Dictionary<int,int>();
        dict.Add(0,1);
        var presum = 0;
        var ans = 0;
        for(int i=0;i<nums.Length;i++)
        {
            presum += nums[i];
            if(dict.ContainsKey(presum - goal)) ans += dict[presum - goal];
            
            if(!dict.ContainsKey(presum)) dict.Add(presum, 0);
            dict[presum]++;
            
            
        }
        
        return ans;
    }
}