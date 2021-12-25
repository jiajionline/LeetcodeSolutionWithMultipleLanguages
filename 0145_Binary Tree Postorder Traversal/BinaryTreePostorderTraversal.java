class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();

        left.add(root);

        while(left.size()>0){
            TreeNode node = left.pop();
            right.add(node);

            if(node.left!=null) left.add(node.left);
            if(node.right!=null) right.add(node.right);
        }
            while(right.size() > 0){
                list.add(right.pop().val);
            }
        }
    }
}