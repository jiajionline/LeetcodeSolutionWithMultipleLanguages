class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack();
        TreeNode p = root;
        while(p!=null || !stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                ans.add(p.val);
                p = p.right;
            }
        }

        return ans;
    }
}