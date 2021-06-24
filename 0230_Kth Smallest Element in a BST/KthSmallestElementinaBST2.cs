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
    public int KthSmallest(TreeNode root, int k) {
        var stack = new Stack<TreeNode>();
        var currentIndex = 0;
        var ans = 0;
        
        while(root!=null || stack.Count > 0){
            while(root!=null){
                stack.Push(root);
                root = root.left;
            }
            
            root = stack.Pop();
            if(++currentIndex == k){
                ans = root.val;
                break;
            }
            
            root = root.right;
        }
        
        return ans;
    }
}