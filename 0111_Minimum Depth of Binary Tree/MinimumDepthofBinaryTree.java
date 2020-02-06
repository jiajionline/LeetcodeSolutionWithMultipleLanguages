class Solution {
    public int minDepth(TreeNode root) {
    	if(root == null) return 0;
    	int left = minDepth(root.left);
    	int right = minDepth(root.right);
    	return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
   
    /**
     * Another solution.
     * 
    public int minDepth(TreeNode root) {
    	if (root == null) return 0;
    	int left = minDepth(root.left)
    	int right = minDepth(root.right);
    	return 1 + (Math.min(left, right) > 0 ? Math.min(left, right) : Math.max(left, right));
	}
     */
}
