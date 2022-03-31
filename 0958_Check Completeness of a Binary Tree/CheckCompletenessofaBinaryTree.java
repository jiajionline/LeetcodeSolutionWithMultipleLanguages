class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean missing = false;
        while(queue.size() > 0) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode tmpNode = queue.poll();
                if(tmpNode == null) {
                    missing = true;
                }else {
                    if(missing) return false;
                    queue.add(tmpNode.left);
                    queue.add(tmpNode.right);
                }
            }
        }
        
        return true;
    }
}