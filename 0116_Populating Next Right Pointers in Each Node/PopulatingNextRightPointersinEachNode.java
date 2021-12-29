class Solution {
    public Node connect(Node root) {
        connect(root, null, true);
        return root;
    }
    
    private void connect(Node node, Node parent, boolean isLeft) {
        if(node == null) return;
        if(parent!=null) 
            node.next = isLeft ? parent.right : (parent.next == null ? null : parent.next.left);
        connect(node.left, node, true);
        connect(node.right, node, false);
    }
}