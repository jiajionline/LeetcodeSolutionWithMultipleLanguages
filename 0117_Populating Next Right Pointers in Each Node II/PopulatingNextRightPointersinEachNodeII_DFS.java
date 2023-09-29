class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) { 
            root.left.next = root.right != null ? root.right : findNext(root);
        }
        if (root.right != null) { 
            root.right.next = findNext(root);
        }
        
        connect(root.right); 
        connect(root.left);
        return root;
    }

    private Node findNext(Node root) { 
        Node p = root;
        while (p.next != null) { 
            p = p.next;
            if (p.left != null) return p.left;
            if (p.right != null) return p.right;
        }
        return null;
    }
}