class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() > 0) {
            TreeNode node = queue.poll();
            if(low <= node.val && node.val <= high)
                    ans+= node.val;
                if(low < node.val && node.left != null) {
                    queue.add(node.left);
                }
                if(node.val < high && node.right != null) queue.add(node.right);
        }
        
        return ans;
    }
}