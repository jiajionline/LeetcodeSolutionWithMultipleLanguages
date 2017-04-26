import java.util.LinkedList;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }
    
    private boolean isSame(TreeNode left, TreeNode right){
    	if(left == null && right == null) return true;
    	if(left != null && right != null){
    		return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
    	}
    	
    	return false;
    }
    
    public boolean isSymmetricIteration(TreeNode root){
    	if(root == null) return true;
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	queue.add(root);
    	
    	while(queue.size()> 0){
    		TreeNode left = queue.removeFirst();
    		TreeNode right = queue.removeFirst();
    		
    		if(left == null && right == null) continue;
    		if(left == null || right == null) return false;
    		
    		if(left.val == right.val){
    			queue.addLast(left.left);
    			queue.addLast(right.right);
    			queue.addLast(left.right);
    			queue.addLast(right.left);
    		}else{
    			return false;
    		}
    	}
    	
    	return true;    	
    }
}
