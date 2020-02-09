/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        List<Integer> levelToSum = new ArrayList<Integer>();
        traverse(root, 1, levelToSum);
        return levelToSum.get(levelToSum.size()-1);
    }
    
    private void traverse(TreeNode node, int level, List<Integer> levelToSum){
        if(node == null) return;
        if(levelToSum.size() < level){
            levelToSum.add(0);
        }
        
        levelToSum.set(level-1 ,levelToSum.get(level-1) + node.val);
        traverse(node.left, level+1,levelToSum);
        traverse(node.right, level+1,levelToSum);
    }
}