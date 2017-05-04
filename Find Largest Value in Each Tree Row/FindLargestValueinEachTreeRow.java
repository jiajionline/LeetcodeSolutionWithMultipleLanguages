import java.util.*;

public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer,Integer> currentLargestValueMap = new HashMap<Integer,Integer>();
        DFS(root, 1, currentLargestValueMap);
        List<Integer> ret = new ArrayList<Integer>(currentLargestValueMap.size());
        for(int i=1;i<=currentLargestValueMap.size();i++){
        	ret.add(currentLargestValueMap.get(i));
        }
        
        return ret;
    }
    
    private void DFS(TreeNode node, int level, Map<Integer,Integer> largestValueMap){
    	if(node == null) return;
    	if(largestValueMap.containsKey(level)){
    		largestValueMap.put(level, Math.max(node.val, largestValueMap.get(level)));
    	}else{
    		largestValueMap.put(level, node.val);
    	}
    	
    	DFS(node.left, level+1, largestValueMap);
    	DFS(node.right, level+1, largestValueMap);
    }
}
