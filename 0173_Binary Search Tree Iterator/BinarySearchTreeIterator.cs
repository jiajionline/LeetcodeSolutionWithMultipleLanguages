/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        PushAllLeftChild(root);
    }
    
    /** @return the next smallest number */
    public int Next() {
        var current = stack.Pop();
        PushAllLeftChild(current.right);
        return current.val;
    }
    
    /** @return whether we have a next smallest number */
    public bool HasNext() {
        return stack.Count > 0;
    }
    
    private void PushAllLeftChild(TreeNode node){
        var current = node;
        while(current!=null){
            stack.Push(current);
            current = current.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */