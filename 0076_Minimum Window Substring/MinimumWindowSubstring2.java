class Solution {
    public String minWindow(String s, String t) {
        int left = 0, count = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c) > 0) count++;
                map.put(c, map.get(c) - 1);
            }
            
            while(count == t.length()) {
                if(i - left + 1 < minLen) {
                    minLen = i - left + 1;
                    minStart = left;
                }
                
                char ch = s.charAt(left);
                if(map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) > 0) count--;    
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}