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
    public bool FindTarget(TreeNode root, int k) {
        if(root == null) return false;
        
        var list = new List<int>();
        var stack = new Stack<TreeNode>();
        
        while(root!=null || stack.Count > 0)
        {
            while(root!=null)
            {
                stack.Push(root);
                root = root.left;
            }
            
            root = stack.Pop();
            list.Add(root.val);
            root = root.right;
        }
        
        var l = 0;
        var r = list.Count -1;
        while(l < r)
        {
            var v = list[l] + list[r];
            if(v == k) return true;
            else if(v < k) l++;
            else r--;
        }
        
        return false;
    }
}