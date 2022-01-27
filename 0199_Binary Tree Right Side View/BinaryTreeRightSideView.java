class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        traverse(root, 0, ans);
        return ans;
    }
    
    private void traverse(TreeNode node, int level, List<Integer> list) {
        if(node == null) return;
        if(list.size() == level)
            list.add(node.val);
        else
            list.set(level, node.val);
        
        traverse(node.left, level+1, list);
        traverse(node.right, level+1, list);
    }
}