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
    public IList<string> BinaryTreePaths(TreeNode root) {
        var ret = new List<string>();
        Traverse(root, "", ret);
        return ret;
    }
    
    private void Traverse(TreeNode node, string s, IList<string> ret)
    {
        if(node == null) return;
        s = s + node.val;
        if(node.left == null && node.right == null){
            ret.Add(s);
        }else{
            Traverse(node.left, s + "->" , ret);
            Traverse(node.right, s + "->", ret);
        }
    }
}