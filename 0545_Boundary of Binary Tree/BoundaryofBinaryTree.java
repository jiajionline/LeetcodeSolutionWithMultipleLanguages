class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return ans;

        ans.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return ans;
    }

    // pre order
    public void leftBoundary(TreeNode node) {
        if(node == null || (node.left == null && node.right == null)) return;
        ans.add(node.val);
        if(node.left == null) 
            leftBoundary(node.right);
        else 
            leftBoundary(node.left);
    }

    // post order
    public void rightBoundary(TreeNode node) {
        if(node == null || (node.left == null && node.right == null)) return;
        if(node.right == null)
            rightBoundary(node.left);
        else 
            rightBoundary(node.right);
        // add after child visit(reverse)
        ans.add(node.val); 
    }
    public void leaves(TreeNode node) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            ans.add(node.val);
            return;
        }
        leaves(node.left);
        leaves(node.right);
    }
}