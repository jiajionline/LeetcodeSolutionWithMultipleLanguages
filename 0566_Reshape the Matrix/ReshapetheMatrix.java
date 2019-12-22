class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null) return nums;
        int m = nums.length, n = nums[0].length;
        if(m * n != r * c) return nums;
        int[][] ans = new int[r][c];
        for(int i=0;i<r * c;i++){
                ans[i/c][i % c] =  nums[i / n][i % n];
        }
        return ans;
    }
}