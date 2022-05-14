class Solution {
    
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node head = null, tail = null, prev = null;
        Stack<Node> stack = new Stack<>();
            
        while(stack.size() > 0 || root != null) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(head == null) {
                head = root;
            }
            
            if(prev!=null) {
                prev.right = root;
                root.left = prev;
            }
            prev = root;
            tail = root;
            root = root.right;
        }
        
        head.left = tail;
        tail.right = head;
        return head;
    }
}