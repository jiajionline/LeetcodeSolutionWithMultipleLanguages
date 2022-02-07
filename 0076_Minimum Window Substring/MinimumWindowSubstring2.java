class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        
        HashMap<Character, Integer> map = new HashMap();
        for(Character c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        int l = 0;
        int r = 0;
        int minL = -1;
        int minLen = s.length() + 1;
        int count = 0;
        
        while(r < s.length()) {
            char c = s.charAt(r);     
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) count++;
            }
            
            while(count == t.length()) {
                if(r - l + 1 < minLen) {
                    minL = l;
                    minLen = r - l + 1;
                }
                
                char tmpChar = s.charAt(l);
                if(map.containsKey(tmpChar)) {
                    map.put(tmpChar, map.get(tmpChar) + 1);
                    if(map.get(tmpChar) > 0) count--;
                }
                
                l++;
            }
            
            r++;
        }
        
        if(minL == -1) return "";
        return s.substring(minL, minL + minLen);
    }
}