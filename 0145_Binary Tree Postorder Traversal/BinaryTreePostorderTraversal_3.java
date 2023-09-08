class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.addFirst(node.val);
            if(node.left !=null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return ans;
    }
}