class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) return ans;
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strings) {
            String converted = convert(s);
            if(!map.containsKey(converted)) map.put(converted, new ArrayList<String>());
            map.get(converted).add(s);
        }
        
        for(List<String> list : map.values()) {
            ans.add(list);
        }
        
        return ans;
    }
    
    private String convert(String s) {
        if(s.length() == 1) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<s.length();i++) {
            int diff = s.charAt(i)  - s.charAt(i-1);
            if(diff < 0) diff += 26;
            sb.append(diff);
            sb.append("-");
        }
        
        return sb.toString();
    }
}