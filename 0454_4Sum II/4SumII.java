class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int v1 : nums1)
            for(int v2 : nums2)
                map.put(v1+v2, map.getOrDefault(v1+v2,0) + 1);
        
        for(int v1 : nums3)
            for(int v2 : nums4)
                ans += map.getOrDefault((0 - (v1 + v2)), 0);
        
        return ans;
    }
}