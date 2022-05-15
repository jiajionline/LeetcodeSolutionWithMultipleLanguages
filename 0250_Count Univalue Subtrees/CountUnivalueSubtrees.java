class Solution {
    private int ans = 0;
    public int countUnivalSubtrees(TreeNode root) {
        traverse(root);
        return ans;
    }
    
    private boolean traverse(TreeNode node) {
        if(node == null) return true;
        boolean left = traverse(node.left);
        boolean right = traverse(node.right);
        
        if(!left || !right) return false;
        
        if(node.left == null && node.right == null) {
            ans++;
            return true;
        }else if(node.left !=null && node.right !=null) {
            if(node.left.val == node.right.val && node.right.val == node.val) {
                ans++;
                return true;
            }
        }else if(node.left != null) {
            if(node.left.val == node.val) {
                ans++;
                return true;
            }   
        }else if(node.right!=null){
            if(node.right.val == node.val)  {
                ans++;
                return true;
            }
                
        }
        
        return false;
    }
}