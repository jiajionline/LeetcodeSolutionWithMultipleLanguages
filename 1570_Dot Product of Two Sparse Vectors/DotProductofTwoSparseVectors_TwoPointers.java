class SparseVector {

    List<int[]> numIndexList;

    SparseVector(int[] nums) {
        numIndexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                numIndexList.add(new int[]{i, nums[i]});
            }
        }
    }

    public int dotProduct(SparseVector vec) {
        int ans = 0, p = 0, q = 0;
        while (p < numIndexList.size() && q < vec.numIndexList.size()) {
            if (numIndexList.get(p)[0] == vec.numIndexList.get(q)[0]) {
                ans += numIndexList.get(p)[1] * vec.numIndexList.get(q)[1];
                p++;
                q++;
            }
            else if (numIndexList.get(p)[0] > vec.numIndexList.get(q)[0]) {
                q++;
            }
            else {
                p++;
            }
        }
        return ans;
    }
}