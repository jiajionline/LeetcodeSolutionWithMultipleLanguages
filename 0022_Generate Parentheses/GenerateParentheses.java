import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<String>();
        RecursiveGeneration("",0,0,n,ret);
        
        return ret;
        
    }
    
    private void RecursiveGeneration(String str, int l, int r, int n, List<String> ret){
    	if(l == n && r == n){
    		ret.add(str);
    		return;
    	}
    	
    	if(l < n){
    		RecursiveGeneration(str + "(", l+1, r, n, ret);
    	}
    	
    	if(l > r){
    		RecursiveGeneration(str + ")", l , r+1, n, ret);
    	}
    }
    
    
}
