class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int presum = 0;
        
        for(int v : nums)
        {
            presum += v;
            if(map.containsKey(presum - goal))
                ans += map.get(presum - goal);
            
            if(!map.containsKey(presum)) map.put(presum,0);
            map.put(presum, map.get(presum) + 1);
        }
        
        return ans;
        
    }
}