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
    public IList<string> BinaryTreePaths(TreeNode root) {
        var ans = new List<string>();
        var lists = new List<List<int>>();
        
        if(root == null) return ans;
        Traverse(root, new List<int>(), lists);
        
        foreach(var list in lists){
            var sb = new StringBuilder();
            for(int i=0;i<list.Count;i++){
                sb.Append(list[i]);
                if(i < list.Count -1) sb.Append("->");
            }
            ans.Add(sb.ToString());
        }
        
        return ans;
    }
    
    private void Traverse(TreeNode node, List<int> list, List<List<int>> lists)
    {
        if(node == null) return;
        list.Add(node.val);
        if(node.left == null && node.right == null){
            lists.Add(new List<int>(list));
        }
        
        Traverse(node.left, list, lists);
        Traverse(node.right, list, lists);
        list.RemoveAt(list.Count - 1);
    }
}