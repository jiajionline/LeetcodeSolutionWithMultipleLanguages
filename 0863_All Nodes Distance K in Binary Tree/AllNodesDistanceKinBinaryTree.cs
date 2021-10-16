/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 * reference from http://zxi.mytechroad.com/blog/tree/leetcode-863-all-nodes-distance-k-in-binary-tree/
 */
public class Solution {
    private IList<int> ans = new List<int>();
    
    public IList<int> DistanceK(TreeNode root, TreeNode target, int k) {
        InnerDistanceK(root, target, k);
        return ans;
    }
    
    // Returns the distance from root to target.
    // Returns -1 if target does not in the tree.
    private int InnerDistanceK(TreeNode root, TreeNode target, int k)
    {
       if(root == null) return -1;
        if(root == target)
        {
            Collect(target, k);
            return 0;
        }
        
        int l = InnerDistanceK(root.left, target, k);
        int r = InnerDistanceK(root.right, target, k);
        
        //If l >=0 means the target in the left subtree
        if (l >=0)
        {
            if(l == k -1) ans.Add(root.val);
            // Collect nodes in right subtree with depth K - l - 2
            Collect(root.right, k - l - 2);
            return l+1;
        }
        
        if (r >=0)
        {
            if(r == k -1) ans.Add(root.val);
            // Collect nodes in left subtree with depth K - r - 2
            Collect(root.left, k - r - 2);
            return r+1;
        }
        
        return -1;
    }
    
    // Collect nodes that are d steps from root
    private void Collect(TreeNode root, int d)
    {
        if(root == null || d < 0) return;
        if(d == 0) ans.Add(root.val);
        Collect(root.left, d-1);
        Collect(root.right, d-1);
    }
}