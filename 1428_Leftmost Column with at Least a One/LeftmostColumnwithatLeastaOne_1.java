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
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        
        int x = 0, y = n-1, ans = Integer.MAX_VALUE;
        
        while(x < m && y >= 0) {
            if(binaryMatrix.get(x, y) == 1) {
                ans = Math.min(ans, y);
                y--;
            }else{
                x++;
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}