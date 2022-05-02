class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for(String strBan : banned) {
            set.add(strBan.trim().toLowerCase());
        }
        
        List<Pair<String,Integer>> list = cleanse(paragraph);
        for(Pair<String,Integer> pair : list) {
            if(!set.contains(pair.getKey())) return pair.getKey();
        }
        
        return "";
    }
    
    private List<Pair<String,Integer>> cleanse(String paragraph) {
        Map<String,Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : paragraph.toCharArray()) {
            if(Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }else {
                if(sb.length() > 0) {
                    String s = sb.toString();
                    map.putIfAbsent(s, 0);
                    map.put(s, map.get(s) + 1);
                    sb.setLength(0);
                }
            }
        }
        
        if(sb.length() > 0) {
            String s = sb.toString();
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }
        
        
        List<Pair<String,Integer>> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            list.add(new Pair<String,Integer>(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list, (a, b) -> Integer.compare(b.getValue(), a.getValue()));
        return list;
    }
}