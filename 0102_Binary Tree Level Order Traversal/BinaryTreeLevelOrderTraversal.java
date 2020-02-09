import java.util.ArrayList;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList();
		traverse(root, 1, ret);
		return ret;
	}
	
	private void traverse(TreeNode node, int level, List<List<Integer>> ret){
		if(node == null) return;
		if(ret.size() < level) ret.add(new LinkedList<Integer>());
		ret.get(level-1).add(node.val);
		traverse(node.left, level+1, ret);
		traverse(node.right, level+1, ret);
	}
    
    
}