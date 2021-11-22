public class Solution {
    private Dictionary<char, List<char>> dict = new Dictionary<char, List<char>>()    
    {
        {'2', new List<char>(){'a','b','c'}},
        {'3', new List<char>(){'d','e','f'}},
        {'4', new List<char>(){'g','h','i'}},
        {'5', new List<char>(){'j','k','l'}},
        {'6', new List<char>(){'m','n','o'}},
        {'7', new List<char>(){'p','q','r','s'}},
        {'8', new List<char>(){'t','u','v'}},
        {'9', new List<char>(){'w','x','y','z'}},
    };
    public IList<string> LetterCombinations(string digits) {
        if(string.IsNullOrEmpty(digits)) return new List<string>();
        
        var ans = new List<string>();
        var list = new char[digits.Length];
        DFS(digits, 0, list, ans, dict);
        
        return ans;
    }
    
    private void DFS(string digits, int index, char[] list, IList<string> ans, Dictionary<char, List<char>> dict)
    {
        if(index == digits.Length)
        {
            ans.Add(new string(list));
            return;
        }
        
        foreach(var c in dict[digits[index]])
        {
            var original = list[index];
            list[index] = c;
            DFS(digits, index+1, list, ans, dict);
            list[index] = original;
            
        }
    }
}