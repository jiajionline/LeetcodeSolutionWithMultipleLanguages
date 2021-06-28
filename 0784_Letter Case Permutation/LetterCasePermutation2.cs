public class Solution {
    public IList<string> LetterCasePermutation(string s) {
        var ans = new List<string>();
        DFS(s.ToCharArray(), 0, ans);
        return ans;
    }
    
    private void DFS(char[] c_arr, int curr, IList<string> ans)
    {
        if(curr == c_arr.Length){
            ans.Add(new String(c_arr));
            return;
        }
        
        DFS(c_arr, curr+1, ans);
        if(!Char.IsLetter(c_arr[curr])) return;
        c_arr[curr] = (char)(((int)c_arr[curr]) ^ 1 << 5);
        DFS(c_arr, curr+1, ans);
        c_arr[curr] = (char)(((int)c_arr[curr]) ^ 1 << 5);
    }
}