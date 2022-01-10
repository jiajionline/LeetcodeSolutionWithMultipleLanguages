class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<n;i++)
            map.put(nums2[i],i);
        
        
        for(int i=0;i<n;i++)
            ans[i] = map.get(nums1[i]);
        
        return ans;
    }
}