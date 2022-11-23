class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int index = 0, ans = Integer.MIN_VALUE;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while(root!=null || stack.size() > 0) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            index++;
            root = stack.pop();
            if(index == k) {
                ans = root.val;
                break;
            }
            root = root.right;
        }
        
        return ans;
    }
}