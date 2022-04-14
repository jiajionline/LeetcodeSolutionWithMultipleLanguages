class SparseVector {
    
    List<int[]> numIndexList = new ArrayList<int[]>();
    
    //Time = O(N) Space O(Max(L1,L2)) L non-zero elements
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != 0) numIndexList.add(new int[] {i, nums[i]});
        }
    }
    
    //Time = O(L1.log(L2)) Space O(1) L non-zero
    public int dotProduct(SparseVector vec) {
        if (this.numIndexList.size() < vec.numIndexList.size()){
            return dotProduct(this, vec);
        } else {
            return dotProduct(vec, this);
        }
    }
    
    public int dotProduct(SparseVector smallVec, SparseVector largeVec) {
        int ans = 0;
        for (int[] curr: smallVec.numIndexList){
            int[] result = binarySearch(largeVec.numIndexList, curr[0]);
            if (result[0] == curr[0]) ans += curr[1] * result[1];
        }
        return ans;
    }
    
    //upper bound
    private int[] binarySearch(List<int[]> numIndexList, int index){
        int[] result = new int[] {-1,0};
        int l = 0;
        int r = numIndexList.size();
        
        while(l < r){
            int mid = (r - l )/2 + l;
            if (numIndexList.get(mid)[0] > index){
                r = mid;
            } else {
                l = mid+1;
            }
        }
        
        if(l-1 >= 0) return numIndexList.get(l-1);
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);