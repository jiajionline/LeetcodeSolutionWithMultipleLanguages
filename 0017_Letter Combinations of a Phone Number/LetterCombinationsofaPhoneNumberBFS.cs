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
        ans.Add("");
        
        foreach(var number in digits)
        {
            var list = new List<string>();
            
            foreach(var s in ans)
            {
                foreach(var v in dict[number])
                {
                    list.Add(s + v);
                }
            }
            
            ans = list;
        }
        
        return ans;
    }
}