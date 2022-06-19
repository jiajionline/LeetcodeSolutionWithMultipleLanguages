class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        dfs(root, null, parentMap);
        Set<TreeNode> set = new HashSet<>();
        while(p!=null) {
            set.add(p);
            p = parentMap.getOrDefault(p, null);
        }
        
        while(q!= null && !set.contains(q)) {
            q = parentMap.getOrDefault(q, null);
        }
        
        return q;
    }
    
    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if(node == null) return;
        if(parent!=null) parentMap.put(node, parent);
        dfs(node.left, node, parentMap);
        dfs(node.right, node, parentMap);
    }   
}