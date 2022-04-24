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
        int m = grid.length;
        int n = grid[0].length;
        return construct(grid, 0, m-1 , 0, n-1);
    }
    
    private Node construct(int[][] grid, int rowL, int rowR, int colL, int colR) {
        // smallest grid
        if(rowL == rowR && colL == colR) {
            Node node = new Node(grid[rowL][colL] == 1, true);
            return node;
        }
        
        int rowM = (rowR - rowL)/2 + rowL;
        int colM = (colR - colL)/2 + colL;
        Node topLeft = construct(grid, rowL, rowM, colL, colM);
        Node topRight = construct(grid, rowL, rowM, colM+1, colR);
        Node bottomLeft = construct(grid, rowM+1, rowR, colL, colM);
        Node bottomRight = construct(grid, rowM+1, rowR,colM+1, colR);
        
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && 
          topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }else {
            return new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}






























