class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int v : to_delete) set.add(v);
        TreeNode newRoot = traverse(root, set, ans);
        if(newRoot != null) ans.add(newRoot);
        return ans;
    }

    private TreeNode traverse(TreeNode node, Set<Integer> set, List<TreeNode> list) {
        if(node == null) return null;
        TreeNode left = traverse(node.left, set, list);
        TreeNode right = traverse(node.right, set, list);
        if(set.contains(node.val)) {
            if(left != null) list.add(left);
            if(right != null) list.add(right);
        }else{
            node.left = left;
            node.right = right;
        }

        return set.contains(node.val) ? null : node;
    }
}