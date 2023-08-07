class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        Map<String,Boolean> memo = new HashMap<>();
        return canBreak(s, dict, memo);

    }

    private boolean canBreak(String s, Set<String> dict, Map<String,Boolean> memo) {
        if(memo.containsKey(s)) return memo.get(s);
        if(dict.contains(s)) return true;
        boolean canBreak = false;
        for(int i=1;i<s.length();i++) {
            String l = s.substring(0,i);
            String r = s.substring(i);
            if(dict.contains(l) && canBreak(r, dict, memo)){
                canBreak = true;
                break;
            }
        }

        memo.put(s, canBreak);
        return canBreak;
    }
}