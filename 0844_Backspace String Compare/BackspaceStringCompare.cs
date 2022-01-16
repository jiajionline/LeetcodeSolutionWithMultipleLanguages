public class Solution {
    public bool BackspaceCompare(string s, string t) 
    {
        if(string.IsNullOrWhiteSpace(s) && string.IsNullOrWhiteSpace(t)) return true;
        if(string.IsNullOrWhiteSpace(s) || string.IsNullOrWhiteSpace(t)) return false;
        
        return Convert(s).Equals(Convert(t));
    }
    
    private string Convert(string s)
    {
        var stack = new Stack<char>();
        foreach(var c in s)
        {
            if(c == '#' && stack.Count() > 0)
                stack.Pop();
            else if(c!= '#')
                stack.Push(c);
        }
        
        var sb = new StringBuilder();
        while(stack.Count > 0)
            sb.Append(stack.Pop());
        
        return sb.ToString();
    }
}