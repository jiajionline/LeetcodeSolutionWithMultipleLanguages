public class Solution {
    public string SimplifyPath(string path) {
        if(string.IsNullOrEmpty(path)) return "";
        var stack = new Stack<string>();
        var splits = path.Split('/');
        foreach(var split in splits)
        {
            if(split == string.Empty || split.Equals(".")) continue;
            else if(split.Equals(".."))
            {
                if(stack.Count > 0) stack.Pop();
            }else{
                stack.Push(split);
            }
        }
        
        var sb = new StringBuilder();
        var list = stack.ToList();
        list.Reverse();
        foreach(var s in list)
        {
            sb.Append("/");
            sb.Append(s);
        }
        
        var ans = sb.ToString();
        return string.IsNullOrEmpty(ans) ? "/" : ans;
        
    }
}