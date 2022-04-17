class Solution {
    Node head = null;
    Node tail = null;
    
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
         
        convert(root);
        tail.right = head;
        head.left = tail;
        return head;
    }
    
    private void convert(Node node) {
        if(node == null) return; 
        convert(node.left);
        if(tail != null) {
            tail.right = node;
            node.left = tail;
        }else{
            head = node;
        }
        
        tail = node;
        convert(node.right);
    }
}