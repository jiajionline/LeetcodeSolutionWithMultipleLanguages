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
    public bool LeafSimilar(TreeNode root1, TreeNode root2) {
        var list1 = new List<int>();
        var list2 = new List<int>();
        
        collectLeafs(root1, list1);
        collectLeafs(root2, list2);
        
        if(list1.Count != list2.Count) return false;
        for(int i=0;i<list1.Count;i++){
            if(list1[i] != list2[i]) return false;
        }
        
        return true;
    }
    
    private void collectLeafs(TreeNode node, List<int> list){
        if(node == null) return;
        if(node.left == null && node.right == null) list.Add(node.val);
        collectLeafs(node.left, list);
        collectLeafs(node.right, list);
    }
}