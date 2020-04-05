class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        largestValues(root, 1, ans);
        return ans;
    }
    
    private void largestValues(TreeNode node, int level, List<Integer> ans){
        if(node == null) return;
        if(ans.size() < level){
            ans.add(node.val);
        }else{
            ans.set(level-1, Math.max(ans.get(level-1), node.val));
        }
        
        largestValues(node.left, level+1, ans);
        largestValues(node.right, level+1, ans);
    }
}