class SparseVector {
    Map<Integer,Integer> indexToValueMap;
    
    SparseVector(int[] nums) {
        indexToValueMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                indexToValueMap.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : indexToValueMap.entrySet()) {
            if(vec.indexToValueMap.containsKey(entry.getKey())) {
                ans += entry.getValue() * vec.indexToValueMap.get(entry.getKey());
            }
        }
        
        return ans;
        
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);