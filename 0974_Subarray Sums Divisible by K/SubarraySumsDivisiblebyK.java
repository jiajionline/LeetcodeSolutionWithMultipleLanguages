class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefix = 0;
        int ans = 0;
        for(int v : nums) {
            prefix = (prefix + v % k + k) % k;
            ans += map.getOrDefault(prefix, 0);
            map.put(prefix, map.getOrDefault(prefix,0) + 1);
        }
        
        return ans;
    }
}