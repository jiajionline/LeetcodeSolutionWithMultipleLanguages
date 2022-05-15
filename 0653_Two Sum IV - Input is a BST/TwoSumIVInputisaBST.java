/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        traverse(root, list);
        int l = 0, r = list.size() - 1;
        
        while(l < r) {
            int res = list.get(l) + list.get(r);
            if(res == k) return true;
            else if(res > k) {
                r--;
            }else{
                l++;
            }
        }
        
        return false;
    }
    
    private void traverse(TreeNode node, List<Integer> list) {
        if(node == null) return;
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }
}