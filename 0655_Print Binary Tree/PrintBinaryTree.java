class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<List<String>>();
        int height = depth(root);
        if(height == 0) return ans;
        
        int width = (1 << height) - 1;
        for(int i=0;i<height;i++) {
            ans.add(new ArrayList<String>());
            for(int j=0; j<width; j++) {
                ans.get(i).add("");
            }
        }
        
        build(root, 0, 0, width-1, ans);
        return ans;
    }
    
    private int depth(TreeNode node) {
        if(node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
    
    private void build(TreeNode node, int level, int l, int r, List<List<String>> ans) {
        if(node == null) return;
        List<String> list = ans.get(level);
        int mid = (r-l)/2 + l;
        list.set(mid, "" + node.val);
        build(node.left, level+1, l, mid-1, ans);
        build(node.right, level+1, mid+1, r, ans);
    }
}