import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null) return result;
        
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        
        currentLevel.add(root);
        
        while(currentLevel.size() > 0){
        	List<Integer> currentLevelList = new LinkedList<Integer>();
        	
        	while(currentLevel.size() > 0){
        		TreeNode node = currentLevel.poll();
        		currentLevelList.add(node.val);
        		if(node.left !=null)
        			nextLevel.add(node.left);
        		if(node.right != null)
        			nextLevel.add(node.right);        		
        	}
        	
        	result.add(currentLevelList);
        	
        	Queue<TreeNode> temp = currentLevel;
        	currentLevel = nextLevel;
        	nextLevel = temp;
        }
        
        return result;
    }
}
