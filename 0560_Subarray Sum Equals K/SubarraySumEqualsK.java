class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int presum = 0;
        int ans = 0;
        for(int v : nums) {
            presum += v;
            if(map.containsKey(presum - k)) {
                ans += map.get(presum - k);
            }
            
            map.put(presum, map.getOrDefault(presum,0) + 1);
        }
        
        return ans;
    }
}