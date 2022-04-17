class Solution {
    public Node treeToDoublyList(Node root) {
        if( root == null) return root;
        Node preHead = new Node(-1);
        Node prev = preHead;
        Stack<Node> stack = new Stack();
        Node curr = root;

        while(stack.size() > 0 || curr != null){
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

        curr = stack.pop();
        prev.right = curr;
        curr.left = prev;
        prev = curr;
        curr = curr.right;
        }
        
        preHead.right.left = prev;
        prev.right = preHead.right;
        return preHead.right;
    }
}