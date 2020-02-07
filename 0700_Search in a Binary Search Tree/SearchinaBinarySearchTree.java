/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        TreeNode p = root;
        while(p!=null){
            if(p.val == val) return p;
            if(p.val > val){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        
        return null;
    }
}