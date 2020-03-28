/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<IList<string>> PrintTree(TreeNode root) {
        var height = Height(root);
        if(height == 0) return new List<IList<string>>();
        var ret = new List<IList<string>>();
        var width =(1 << height) - 1;
        for(int i = 0; i < height; i++) {
            ret.Add(Enumerable.Repeat("", width).ToList());
        }

        Build(ret, root, 0, 0, width - 1);

        return ret;
    }

    private void Build(IList<IList<string>> ret, TreeNode node, int level, int left, int right) {
        if(node == null) return;
        int mid = left +(right - left) / 2;
        ret[level][mid] = node.val.ToString();
        Build(ret, node.left, level + 1, left, mid - 1);
        Build(ret, node.right, level + 1, mid + 1, right);
    }

    private int Height(TreeNode root) {
        if(root == null) return 0;
        return Math.Max(Height(root.left), Height(root.right)) + 1;
    }
}