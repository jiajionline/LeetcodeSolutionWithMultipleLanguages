class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        traverse(root, "", ans);
        return ans;
    }

    private void traverse(TreeNode node, String str, List<String> ans) {
        if(node == null) return;
        str = str + node.val;
        if(node.left == null && node.right == null) {
            ans.add(str);
            return;
        }
        if(node.left != null) {
            traverse(node.left, str + "->", ans);
        }

        if(node.right != null) {
            traverse(node.right, str + "->", ans);
        }
    }
}