class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ans = null;
        boolean next = false;
        
        while(root!=null || stack.size() > 0) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(root == p) {
                next = true;
                root = root.right;
                continue;
            }
            
            if(next) {
                return root;
            }
            
            root = root.right;
        }
        
        return null;
    }
}