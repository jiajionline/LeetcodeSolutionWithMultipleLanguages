class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for(int i=0;i<s.length();i++) {
            char c_s = s.charAt(i);
            char t_s = t.charAt(i);

            if(!map.containsKey(c_s)) {
                if(!used.add(t_s)) return false;
                map.put(c_s, t_s);
                used.add(t_s);
            }else{
                if(map.get(c_s) != t_s) return false;
            }
        }

        return true;
    }
}