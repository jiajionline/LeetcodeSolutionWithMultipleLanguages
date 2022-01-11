public class Solution {
    public TreeNode InsertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val > root.val)
            root.right = InsertIntoBST(root.right, val);
        else
            root.left = InsertIntoBST(root.left, val);
        
        return root;
    }
}