public class Solution {
	int max = 0;
	public int DiameterOfBinaryTree (TreeNode root) {
		if (root == null) return 0;
		Height (root);
		return max;
	}

	private int Height (TreeNode node) {
		if (node == null) return 0;

		var left = Height (node.left);
		var right = Height (node.right);
		max = Math.Max (max, left + right);

		return Math.Max (left, right) + 1;
	}
}