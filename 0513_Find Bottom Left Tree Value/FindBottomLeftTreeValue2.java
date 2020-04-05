class Solution {
    private int currLevel = 0;
    private int ans = -1;
    
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root,currLevel+1);
        return ans;
    }
    
    private void findBottomLeftValue(TreeNode node, int level){
        if(node == null) return;
        if(level > currLevel){
            currLevel = level;
            ans = node.val;
        }
        
        findBottomLeftValue(node.left,level + 1);
        findBottomLeftValue(node.right,level + 1);
    }
}