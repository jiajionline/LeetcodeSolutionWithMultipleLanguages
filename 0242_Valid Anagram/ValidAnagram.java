public class Solution {
    public boolean isAnagram(String s, String t) {
    	if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char c : s.toCharArray()){
        	if(map.containsKey(c)){
        		map.put(c,map.get(c)+1);
        	}else{
        		map.put(c, 1);
        	}
        }
        
        for(char c : t.toCharArray()){
        	if(map.containsKey(c)){
        		map.put(c, map.get(c)-1);
        	}else{
        		return false;
        	}
        }
        
        for(int i : map.values()){
        	if(i != 0) return false;
        }
        
        return true;
    }
}
