class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums2.length;i++) {
            if(map.containsKey(nums2[i])) {
                map.put(nums2[i], map.get(nums2[i]) + 1);
            }else{
                map.put(nums2[i],1);
            }
        }
        
        for(int i=0;i<nums1.length;i++) {
            if(map.containsKey(nums1[i])) {
                ans.add(nums1[i]);
                map.put(nums1[i], map.get(nums1[i]) - 1);
                if(map.get(nums1[i]) == 0) map.remove(nums1[i]);
            }
        }
        
        return ans.stream().mapToInt(i->i).toArray();
    }
}