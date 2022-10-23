class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(root, 0, ans);
        return ans;
    }
    
    private void DFS(TreeNode node, int level, List<List<Integer>> ans) {
        if(node == null) return;
        if(level == ans.size()) {
            ans.add(new ArrayList<Integer>());
        }
        
        ans.get(level).add(node.val);
        DFS(node.left, level+1, ans);
        DFS(node.right, level+1, ans);
    } 
}