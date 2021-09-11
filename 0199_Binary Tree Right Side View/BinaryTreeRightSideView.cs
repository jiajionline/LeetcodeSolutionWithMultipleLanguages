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
    private Dictionary<int,int> levelToRightNode = new Dictionary<int,int>();
    
    public IList<int> RightSideView(TreeNode root) {
        RightSideView(root, 1);
        
        var ans = new List<int>();
        for(int i=0;i<levelToRightNode.Count;i++)
        {
            ans.Add(levelToRightNode[i+1]);
        }
        
        return ans;
    }
    
    private void RightSideView(TreeNode node, int level)
    {
        if(node == null) return;
        if(!levelToRightNode.ContainsKey(level)) levelToRightNode.Add(level, node.val);
        RightSideView(node.right, level+1);
        RightSideView(node.left, level+1);
    }
}