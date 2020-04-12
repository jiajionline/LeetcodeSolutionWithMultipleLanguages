class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        
        List<Integer> list = KMP.match(haystack, needle);
        if(list!=null && list.size() > 0){
            return list.get(0);
        }else{
            return -1;
        }
    }
}


public class KMP{
    public static List<Integer> build(String p){
        int m = p.length();
        List<Integer> nxt = new ArrayList<Integer>();
        nxt.add(0); nxt.add(0);

        for(int i=1, j = 0; i<m; i++){
            while(j > 0 && p.charAt(i) != p.charAt(j))
                j = nxt.get(j);
            if(p.charAt(i) == p.charAt(j))
                j++;
            nxt.add(j);
        }
        return nxt;
    }
    
    public static List<Integer> match(String s, String p){
    	List<Integer> nxt = build(p);
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	int n = s.length();
    	int m = p.length();
    	
    	for(int i = 0, j =0;i<n;i++) {
    		while(j > 0 && s.charAt(i)!=p.charAt(j))
    			j = nxt.get(j);
    		if(s.charAt(i) == p.charAt(j))
    			j++;
    		if(j == m) {
    			ans.add(i - m + 1);
    			j = nxt.get(j);
    		}
    	}
    	
    	return ans;
    }
}