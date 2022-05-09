class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        height(root, ans);
        return ans;
    }
    
    private int height(TreeNode node, List<List<Integer>> ans) {
        if(node == null) return -1;
        int height = Math.max(height(node.left, ans), height(node.right, ans)) + 1;
        if(ans.size() == height) ans.add(new ArrayList<Integer>());
        ans.get(height).add(node.val);
        return height;
    }
}