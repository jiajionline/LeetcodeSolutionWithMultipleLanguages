public class Solution {
    public int lengthLongestPath(String input) {
        int ans = 0;
        Map<Integer, Integer> m = new HashMap<>();
        //for root. 
        m.put(0, 0);
        for (String s : input.split("\n")) {
            //if the root doesn't have '\t', it returns -1 , and + 1 so then the level is 0
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.contains(".")) {
                ans = Math.max(ans, m.get(level) + len);
            } else {
                m.put(level + 1, m.get(level) + len + 1);
            }
        }
        return ans;
    }
}