class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String ans = "";
        int freq = 0;
        paragraph = cleanup(paragraph);
        String[] strArr = paragraph.split(" ");
        Set<String> bannedSet = new HashSet<>();
        for(String strBan : banned){
            bannedSet.add(strBan.toLowerCase());
        }

        Map<String, Integer> map = new HashMap();
        for(String str : strArr) {
            String s = str.toLowerCase();
            if(s.length() == 0) continue;
            if(!bannedSet.contains(s)) {
                map.putIfAbsent(s,0);
                map.put(s, map.get(s)+1);
                if(map.get(s) > freq) {
                    ans = s;
                    freq = map.get(s);
                }
            }
        }

        return ans;
    }

    private String cleanup(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if("!?',;.".indexOf(c) >= 0) {
                sb.append(' ');
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}