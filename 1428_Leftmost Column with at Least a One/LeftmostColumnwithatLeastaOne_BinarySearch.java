/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int m = dim.get(0), n = dim.get(1);
        int ans = n;
        for(int row = 0;row<m;row++) {
            int result = binarySearch(binaryMatrix, row, n);
            ans = Math.min(ans, result);
        }

        return ans == n ? -1 : ans;
    }

    private int binarySearch(BinaryMatrix binaryMatrix, int row, int n) {
        int l = 0, r = n;
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(binaryMatrix.get(row, mid) > 0) {
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }
}