class Solution {
    private Node head;
    private Node tail;
    public Node treeToDoublyList(Node root) {
        inOrder(root);
        if(head != null) {
            tail.right = head;
            head.left = tail;
        }
        return head;
    }
    
    private void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        if(tail!=null) {
            tail.right = node;
            node.left = tail;
        }else{
            head = node;
        }
        
        tail = node;
        inOrder(node.right);
    }
}