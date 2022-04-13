class Solution {
    private int ans = 0;
    public int maxLength(List<String> arr) {
        dfs(0, arr, "");
        return ans;
    }
    
    public void dfs(int start, List<String> arr, String str){
        if(!isUnique(str)){
            return;
        }
        ans = Math.max(ans, str.length());
        
        for(int i=start; i<arr.size();i++){
            String s = arr.get(i);
            dfs(i+1, arr, str + s);
        }
    }
    
    public static boolean isUnique(String s){
        int unique = 0;
        
        for(char ch: s.toCharArray()){
            if(((1 << (ch - 'a')) & unique) > 0) return false;
            unique = (1 << (ch - 'a') | unique);
        }
        return true;
    }
}