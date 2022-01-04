class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<String>();
        if(words == null || words.length <= 1) return ans;
        
        HashMap<String,Boolean> memo = new HashMap<String,Boolean>();
        HashSet<String> set = new HashSet<String>(Arrays.asList(words));
       
        for (String word : words) if (DFS(word, set, memo)) ans.add(word);        
        return ans;
        
        
    }
    
    private boolean DFS(String s, HashSet<String> set, HashMap<String,Boolean> memo)
    {
        if(memo.containsKey(s)) return memo.get(s);
        memo.put(s, false);
        for(int i=1;i<s.length();i++)
        {
            if(set.contains(s.substring(0,i))) {
                
                String r = s.substring(i);
                if(set.contains(r) || DFS(r, set, memo)) {
                    memo.put(s,true);
                    return true;
                }
            }
        }
        
        return false;
    }
}