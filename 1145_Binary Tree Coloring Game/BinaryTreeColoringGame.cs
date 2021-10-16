/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    
    private int redLeft;
    private int redRight;
    
    public bool BtreeGameWinningMove(TreeNode root, int n, int x) {
            Count(root, x);
            // Color Red's parent.
            if (1 + redLeft + redRight <= n / 2) return true;
            
            // Color the child that has the larger subtree.
            return Math.Max(redLeft, redRight) > n / 2;
    }
    
    private int Count(TreeNode node, int x)
    {
        if(node == null) return 0;
        var l = Count(node.left, x);
        var r = Count(node.right, x);
        
        if(node.val == x)
        {
            redLeft = l;
            redRight = r;
        }
        
        return l + r + 1;
    }
}