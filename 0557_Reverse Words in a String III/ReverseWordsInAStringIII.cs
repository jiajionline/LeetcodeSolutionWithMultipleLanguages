public class Solution {
    public string ReverseWords(string s) {
        var n = s.Length;
        var chars = s.ToCharArray();
        var l = 0;
        var r = 0;
        var whitespace = true;
        while(r < n)
        {
            if(chars[r] != ' ' && whitespace)
            {
                l = r;
                whitespace = false;
            }else if(chars[r] == ' ' && !whitespace)
            {
                Reverse(chars, l, r-1);
                whitespace = true;
            }
            
            r++;
        }
        
        if(!whitespace) Reverse(chars, l, r-1);
        
        return new String(chars);
    }
    
    private void Reverse(char[] chars, int l , int r)
    {
        while(l < r) {
            var tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
    }
}