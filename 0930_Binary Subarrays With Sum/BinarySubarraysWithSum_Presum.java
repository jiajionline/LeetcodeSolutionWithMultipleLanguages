class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int presum = 0;
        int ans = 0;
        for(int v : nums) {
            presum += v;
            ans += map.getOrDefault(presum - goal, 0);
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        
        return ans;
    }
}