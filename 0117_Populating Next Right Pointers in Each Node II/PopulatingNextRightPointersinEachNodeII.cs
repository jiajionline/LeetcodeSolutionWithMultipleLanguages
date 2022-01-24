public class Solution {
    public Node Connect(Node root) {
        if(root == null) return root;
        if(root.left!=null)
        {
            if(root.right!=null)
                root.left.next = root.right;
            else
                root.left.next = FindNext(root);
        }
        
        if(root.right!=null)
        {
            root.right.next = FindNext(root);
        }
        
        
        Connect(root.right);
        Connect(root.left);
        
        return root;
    }
    
    private Node FindNext(Node node)
    {
        var p = node;
        while(p.next!=null)
        {
            p = p.next;
            if(p.left != null) return p.left;
            if(p.right != null) return p.right;
        }
        
        return null;
    }
}