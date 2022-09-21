class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            map.putIfAbsent(newStr, new ArrayList<String>());
            map.get(newStr).add(s);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list : map.values())
            ans.add(list);
        
        return ans;
    }
}