class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new LinkedList<>();
        postorder(root, new HashMap<>(), ans);
        return ans;
    }

    public String postorder(TreeNode node, Map<String, Integer> map, List<TreeNode> ans) {
        if (node == null) return "#";  
        String serialized = node.val + "," + postorder(node.left, map, ans) + "," + postorder(node.right, map, ans);
        map.put(serialized, map.getOrDefault(serialized, 0) + 1);
        if (map.get(serialized) == 2) ans.add(node);
        return serialized;
    }
}