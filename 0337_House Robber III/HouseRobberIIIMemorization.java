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
    private HashMap<TreeNode,Integer> map = new HashMap();
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);

        int val = root.val;
        int ll = root.left != null ? rob(root.left.left) : 0;
        int lr = root.left != null ? rob(root.left.right) : 0;
        int rl = root.right != null ? rob(root.right.left) : 0;
        int rr = root.right != null ? rob(root.right.right) : 0;

        int max = Math.max(val + ll + lr + rl + rr, rob(root.left) + rob(root.right));
        map.put(root, max);
        return max;
    }
}