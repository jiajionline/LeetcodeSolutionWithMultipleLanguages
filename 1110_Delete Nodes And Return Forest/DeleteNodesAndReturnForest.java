import java.util.*;

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new LinkedList<TreeNode>();
        Set<Integer> set = new HashSet<Integer>();
        for (int v : to_delete) {
            set.add(v);
        }
        postOrder(root, set, ans);
        if (!set.contains(root.val))
            ans.add(root);
        return ans;
    }

    private TreeNode postOrder(TreeNode node, Set set, List<TreeNode> ans) {
        if (node == null)
            return null;
        node.left = postOrder(node.left, set, ans);
        node.right = postOrder(node.right, set, ans);
        if (!set.contains(node.val))
            return node;
        if (node.left != null)
            ans.add(node.left);
        if (node.right != null)
            ans.add(node.right);
        return null;
    }
}