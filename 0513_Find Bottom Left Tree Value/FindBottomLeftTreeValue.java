public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        TreeNode mostLeft = null;
        
        while(!queue.isEmpty()){
        	mostLeft = queue.removeFirst();
        	if(mostLeft.right!=null) queue.addLast(mostLeft.right);
        	if(mostLeft.left!=null) queue.addLast(mostLeft.left);
        }
        
        return mostLeft.val;
    }
}
