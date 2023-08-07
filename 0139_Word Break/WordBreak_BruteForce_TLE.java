class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return canBreak(s, set);
    }
    
    private boolean canBreak(String s, Set<String> set) {
        if(set.contains(s)) return true;
        for(int i=1;i<s.length();i++) {
            if(set.contains(s.substring(0, i)) && canBreak(s.substring(i), set)) return true;
        }
        
        return false;
    }
}