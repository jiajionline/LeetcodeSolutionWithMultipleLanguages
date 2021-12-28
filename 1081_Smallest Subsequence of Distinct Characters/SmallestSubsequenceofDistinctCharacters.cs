public class Solution {
    public string SmallestSubsequence(string s) {
     var stack = new Stack<char>();
        var seen = new HashSet<char>();
        var lastOccurrence = new int[26];
        Array.Fill(lastOccurrence, -1);
        
        for(var i = 0;i<s.Length;i++)
            lastOccurrence[s[i]-'a'] = i;
        
        for(var i = 0; i<s.Length;i++)
        {
            var c = s[i];
            if(!seen.Contains(c))
            {
                while(stack.Count > 0 && c < stack.Peek() && lastOccurrence[stack.Peek() - 'a'] > i)
                    seen.Remove(stack.Pop());
                
                seen.Add(c);
                stack.Push(c);
            }
        }
        
        var sb = new StringBuilder(stack.Count);
        while(stack.Count > 0)
            sb.Append(stack.Pop());
        
         var char_arr = sb.ToString().ToCharArray();
        Array.Reverse(char_arr);
        return new String(char_arr);
    }
}