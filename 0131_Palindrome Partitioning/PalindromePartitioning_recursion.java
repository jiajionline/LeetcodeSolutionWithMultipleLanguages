class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if(s.isBlank()) return ans;
        DFS(s, 0, new ArrayList<String>(), ans);
        return ans;
    }
    
    private void DFS(String s, int index, List<String> list, List<List<String>> ans) {
        if(index == s.length()) {
            ans.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i=index;i<s.length();i++) {
            if(isPalindrome(s, index, i)) {
                list.add(s.substring(index, i+1));
                DFS(s, i+1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l , int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}