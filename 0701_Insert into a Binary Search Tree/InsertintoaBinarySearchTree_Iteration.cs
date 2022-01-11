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
    public TreeNode InsertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        
        var curr = root;
        
        while(true)
        {
            if(curr.val > val)
            {
                if(curr.left == null)
                {
                    curr.left = new TreeNode(val);
                    break;
                }else{
                    curr = curr.left;
                }
            }else{
                if(curr.right == null)
                {
                    curr.right = new TreeNode(val);
                    break;
                }else{
                    curr = curr.right;
                }
            }
        }
        return root;
    }
}