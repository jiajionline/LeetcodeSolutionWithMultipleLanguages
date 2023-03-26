class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] splits = s.split(" ");
        if(pattern.length() != splits.length) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        for(int i=0;i<pattern.length();i++) {
            char c = pattern.charAt(i);
            String str = splits[i];
            if(!map.containsKey(c)) {
                if(used.contains(str)) return false;
                map.put(c, str);
                used.add(str);
            }else{
                String strFromMap = map.get(c);
                if(!strFromMap.equals(str)) return false;
            }
        }
        
        return true;
    }
}