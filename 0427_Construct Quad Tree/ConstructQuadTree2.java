/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return build(grid, 1, n, 1, n);
    }
    
    private Node build(int[][] grid, int  rowTop, int rowBottom, int colLeft, int colRight) 
    {
        if(rowTop == rowBottom && colLeft == colRight) {
            return new Node(grid[rowTop-1][colLeft-1] == 1, true, null, null, null, null);
        }
        int rowMid = (rowBottom - rowTop)/2 + rowTop;
        int colMid = (colRight - colLeft)/2 + colLeft;
        
        Node topLeft = build(grid, rowTop, rowMid, colLeft, colMid);
        Node topRight = build(grid, rowTop, rowMid, colMid+1, colRight);
        Node bottomLeft = build(grid, rowMid + 1, rowBottom, colLeft, colMid);
        Node bottomRight = build(grid, rowMid + 1, rowBottom, colMid + 1, colRight);
        
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && 
          topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }else{
            return new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}