public class Solution {
    public string RemoveDuplicates(string s) {
        if(string.IsNullOrEmpty(s)) return s;
        var stack = new Stack<char>();
        foreach(var c in s)
        {
            if(stack.Count == 0){
                stack.Push(c);
            }else{
                if(stack.Peek() == c){
                    stack.Pop();
                }else{
                    stack.Push(c);
                }
            }
        }
        
        var chars = new char[stack.Count];
        for(int i=chars.Length-1;i>=0;i--)
            chars[i] = stack.Pop();
        
        return new String(chars);
    }
}