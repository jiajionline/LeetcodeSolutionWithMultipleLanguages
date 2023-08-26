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
        int x = 0, y = n-1;
        while(x < m && y >= 0) {
            if(binaryMatrix.get(x, y) == 1){
                ans = Math.min(ans, y);
                y--;
            }else{
                x++;
            }
        }
        return ans == n ? -1 : ans;

    }
}