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
        List<Integer> list = binaryMatrix.dimensions();
        int rows = list.get(0);
        int cols = list.get(1);
        
        int ans = Integer.MAX_VALUE;
        
        for(int row=0; row < rows; row++) {
            int l = 0, r = cols;

            while(l < r) {
                int col = (r-l)/2 + l;
                if(binaryMatrix.get(row, col) > 0) {
                    r = col;
                }else {
                    l = col + 1;
                }
            }

            if(l < cols) {
                ans = Math.min(ans, l);
            }
        }
         
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}