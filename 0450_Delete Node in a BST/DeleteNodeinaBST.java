class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            root.val = smallest(root.right).val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    private TreeNode smallest(TreeNode root)
       {
           TreeNode node = root;
           while (node.left != null)
           {
               node = node.left;
           }

           return node;
       }
}