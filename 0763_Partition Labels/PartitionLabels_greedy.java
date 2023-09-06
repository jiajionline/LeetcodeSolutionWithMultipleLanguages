class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)  map.put(s.charAt(i), i);
        
        int index = 0;
        int furthest = 0;
        List<Integer> ans = new ArrayList<>();
        while(index < s.length()) {
            int i = index;
            while(i <= furthest) {
                furthest = Math.max(furthest, map.get(s.charAt(i)));
                i++;
            }

            ans.add(furthest - index + 1);
            index = furthest + 1;
            furthest = index;
        }
        return ans;
    }
}