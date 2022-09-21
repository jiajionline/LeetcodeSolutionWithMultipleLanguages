class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        int[] count = new int[26];
        for(String s : strs) {
            StringBuilder sb = new StringBuilder();
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()) count[c - 'a']++;
            for(int cnt : count) sb.append(cnt + "#");
            
            String newStr = new String(sb.toString());
            map.putIfAbsent(newStr, new ArrayList<String>());
            map.get(newStr).add(s);
        }
        
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(map.values());
        return ans;
    }
}