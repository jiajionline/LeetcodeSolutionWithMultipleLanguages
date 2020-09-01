/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        StringBuffer sb = new StringBuffer();
        sb.append(t.val);
        
        if(t.left!=null){
            sb.append("(" + tree2str(t.left)+")");
        }

        if(t.right!=null){
            if(t.left==null) sb.append("()");
            sb.append("(" + tree2str(t.right)+")");
        }
        return sb.toString();       
    }
}