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
    private int ans = 0;
    public int PathSum(TreeNode root, int sum) {
        if(root == null) return ans;
        
        PathSum(root, sum, new List<int>());
        return ans;
        
        
    }
    
    private void PathSum(TreeNode node, int sum, IList<int> list){
        if(node == null) return;
        list.Add(node.val);
        
        int tmpSum = 0;
        for(int i=list.Count-1;i>=0;i--){
            tmpSum += list[i];
            if(tmpSum == sum){
                ans++;
            }
        }
        
        PathSum(node.left, sum, list);
        PathSum(node.right, sum, list);
        
        list.RemoveAt(list.Count - 1);
    }
}