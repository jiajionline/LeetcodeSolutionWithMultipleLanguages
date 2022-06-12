class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || stack.size() > 0) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        
        return ans;
    }
}