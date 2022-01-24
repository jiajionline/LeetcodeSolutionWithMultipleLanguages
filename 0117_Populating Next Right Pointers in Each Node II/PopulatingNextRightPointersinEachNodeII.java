class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) { 
            if (root.right != null) 
                root.left.next = root.right; 
            else 
                root.left.next = findNext(root); 
        }
        if (root.right != null) { 
            root.right.next = findNext(root);
        }
        
        connect(root.right); 
        connect(root.left);
        return root;
    }

    private Node findNext(Node root) { 
        while (root.next != null) { 
            root = root.next;
            if (root.left != null) return root.left;
            if (root.right != null) return root.right;
        }
        return null;
    }
}