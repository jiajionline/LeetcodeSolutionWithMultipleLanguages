class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while(p!=null || stack.size() > 0) {
            if(p != null) {
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                p = p.right;
            }
        }
        
        return list;
    }
}