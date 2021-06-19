/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private Dictionary<int,int> dict = new Dictionary<int,int>();
    private int maxLevel = 0;
    
    public int DeepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        Traverse(root, 1);
        return dict[maxLevel];
    }
    
    private void Traverse(TreeNode node, int level)
    {
        if(node == null) return;
        maxLevel = Math.Max(maxLevel, level);
        
        if(!dict.ContainsKey(level)){
            dict.Add(level, 0);
        }
        
        dict[level] += node.val;
        Traverse(node.left, level+1);
        Traverse(node.right, level+1);
    }
}