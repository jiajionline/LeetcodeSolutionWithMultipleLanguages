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
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        var ans = new List<IList<int>>();
        if(root == null) return ans;
        
        Traverse(root, targetSum, new List<int>(), ans);
        
        return ans;
    }
    
    private void Traverse(TreeNode node, int targetSum, List<int> list, IList<IList<int>> ans)
    {
        if(node == null) return;
        list.Add(node.val);
        if(node.left == null && node.right == null && node.val == targetSum){
            ans.Add(new List<int>(list));
        }
        
        Traverse(node.left, targetSum - node.val, list, ans);
        Traverse(node.right, targetSum - node.val, list, ans);
        list.RemoveAt(list.Count - 1);
    }
}