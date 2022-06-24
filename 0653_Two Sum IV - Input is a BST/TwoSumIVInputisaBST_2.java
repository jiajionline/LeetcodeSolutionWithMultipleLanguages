class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, true);
        BSTIterator right = new BSTIterator(root, false);
        while(left.hasNext() && right.hasNext()) {
            int l = left.peek(), r = right.peek();
            if(l>=r) return false;
            if(l + r == k) return true;
            else if(l + r < k) left.next();
            else right.next();
        }
        
        return false;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack;
    private boolean isForward;
    public BSTIterator(TreeNode root, boolean isForward) {
        this.stack = new Stack<>();
        this.isForward = isForward;
        if(isForward) pushAllLeft(root);
        else pushAllRight(root);
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int next() {
        TreeNode node = stack.pop();
        if(isForward) pushAllLeft(node.right);
        else pushAllRight(node.left);
        return node.val;
    }
    
    private void pushAllLeft(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
    private void pushAllRight(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.right;
        }
    }
    
    public int peek() {
        return stack.peek().val;
    }
}