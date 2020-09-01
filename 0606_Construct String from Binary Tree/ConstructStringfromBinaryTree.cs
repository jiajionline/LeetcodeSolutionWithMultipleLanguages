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
    public string Tree2str(TreeNode t) {
        if(t == null) return "";
        var sb = new StringBuilder();
        sb.Append(t.val);
        
        if(t.left!=null){
            sb.Append("(" + Tree2str(t.left)+")");
        }

        if(t.right!=null){
            if(t.left==null) sb.Append("()");
            sb.Append("(" + Tree2str(t.right)+")");
        }
        return sb.ToString();
    }
}