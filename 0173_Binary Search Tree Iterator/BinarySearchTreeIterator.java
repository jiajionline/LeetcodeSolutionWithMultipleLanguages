class BSTIterator {
    private TreeNode _root;
    private Stack<TreeNode> _stack;

    public BSTIterator(TreeNode root) {
        _root = root;
        _stack = new Stack<TreeNode>();
    }
    
    public int next() {
        int v = 0;
        
        while(_root!=null) {
            _stack.push(_root);
            _root = _root.left;
        }
        
        if(_stack.size() > 0) {
            _root = _stack.pop();
            v = _root.val;
            _root = _root.right;
        } 
        return v;
    }
    
    public boolean hasNext() {
        return _root!=null || _stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */