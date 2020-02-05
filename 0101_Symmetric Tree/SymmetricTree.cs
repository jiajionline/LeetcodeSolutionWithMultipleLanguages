public class Solution {
    public bool IsSymmetric (TreeNode root) {
        if (root == null) return true;
        return IsSame (root, root);
    }

    private bool IsSame (TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null && nodeB == null) return true;
        
        if (nodeA != null && nodeB != null && nodeA.val == nodeB.val) {
            return IsSame (nodeA.left, nodeB.right) && IsSame (nodeA.right, nodeB.left);
        } else {
            return false;
        }
    }
}