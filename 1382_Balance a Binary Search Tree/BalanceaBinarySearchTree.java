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
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return root;
        List<TreeNode> list = new ArrayList<TreeNode>();
        inOrderTraverse(root, list);
        return buildBST(0, list.size()-1, list);
    }

    private void inOrderTraverse(TreeNode node, List<TreeNode> list){
        if(node == null) return;
        inOrderTraverse(node.left, list);
        list.add(node);
        inOrderTraverse(node.right, list);
    }

    private TreeNode buildBST(int l, int r, List<TreeNode> list){
        if(l > r) return null;
        int m = l + (r - l)/2;
        TreeNode node = list.get(m);
        node.left = buildBST(l, m-1, list);
        node.right = buildBST(m+1,r,list);
        return node;
    }
}