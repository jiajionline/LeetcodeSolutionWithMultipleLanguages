public class Solution {

    private final Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<String>(wordDict));    
    }

    private List<String> wordBreak(String s, Set<String> dict) {
        //already calculated, just return the result
        if (cache.containsKey(s)) return cache.get(s);
        List<String> result = new LinkedList<>();
        if (dict.contains(s)) result.add(s);
        for (int i = 1; i < s.length(); i++) {
            //split two parts
            String l = s.substring(0,i);
            String r = s.substring(i);
            if (dict.contains(l) && containsSuffix(r , dict)) {
                //get sub problem recursively
                for (String ss : wordBreak(r, dict)) {
                    result.add(l + " " + ss);
                }
            }
        }
        cache.put(s, result);
        return result;
    }

    private boolean containsSuffix(String str, Set<String> dict) {
        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(i))) return true;
        }
        return false;
    }
}