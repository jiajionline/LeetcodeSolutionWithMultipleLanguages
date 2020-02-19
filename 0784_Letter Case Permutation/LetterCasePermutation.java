class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<String>();
        DFS(S.toCharArray(), 0, ans);
        return ans;
    }
    
    private void DFS(char[] c_arr, int s,  List<String> ans){
        if(s == c_arr.length){
            ans.add(new String(c_arr));
            return;
        }
        
        DFS(c_arr, s+1, ans);
        if(!Character.isLetter(c_arr[s])) return;
        c_arr[s] ^= 1 << 5;
        DFS(c_arr, s+1, ans);
        c_arr[s] ^= 1 << 5;
    }
}