class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return ans;
        DFS(s, 0, new ArrayList<String>(), ans);
        return ans;

    }

    private void DFS(String str, int s,List<String> curr, List<List<String>> ans){
        if(str.length() == s){
            ans.add(new ArrayList<String>(curr));
            return;
        }

        for(int i=s;i<str.length();i++){
            if(isPalindrome(str, s, i)){
                curr.add(str.substring(s, i+1));
                DFS(str,i+1,curr,ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end){
        while(start < end){
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }

        return true;
    }
}