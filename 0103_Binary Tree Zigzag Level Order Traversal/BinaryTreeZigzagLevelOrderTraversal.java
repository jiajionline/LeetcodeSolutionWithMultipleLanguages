class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        traverse(root, 0, ans);
        
        for(int i=1;i<ans.size();i+=2) {
            Collections.reverse(ans.get(i));
        }
        
        return ans;
    }
    
    private void traverse(TreeNode node, int level, List<List<Integer>> ans) {
        if(node == null) return;
        if(level+1 > ans.size())
            ans.add(new ArrayList<Integer>());
        ans.get(level).add(node.val);
        traverse(node.left, level+1, ans);
        traverse(node.right, level+1, ans);
    }
}