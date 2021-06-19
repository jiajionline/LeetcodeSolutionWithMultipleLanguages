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
    public IList<IList<int>> LevelOrderBottom(TreeNode root) {
        var ans = new List<IList<int>>();
        if(root == null) return ans;
        
        var queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        
        while(queue.Count > 0)
        {
            ans.Add(new List<int>());
            var size = queue.Count;
            
            while(size-- > 0)
            {
                var n = queue.Dequeue();
                ans[ans.Count-1].Add(n.val);
                
                if(n.left!=null) queue.Enqueue(n.left);
                if(n.right!=null) queue.Enqueue(n.right);
            }
        }
        
        ans.Reverse();
        
        return ans;
    }
}