class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || stack.size() > 0) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                if(prev != null && first == null && root.val < prev.val) {
                    first = prev;
                }
                
                if(prev != null && first != null && root.val < prev.val) {
                    second = root;
                }
                
                prev = root;
                
                root = root.right;
            }
        }
        
        int v = first.val;
        first.val = second.val;
        second.val = v;
    }
}