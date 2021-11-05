public class Solution {
    public int RomanToInt(string s) {
        var dict = new Dictionary<char,int>();
        dict.Add('I',1);
        dict.Add('V',5);
        dict.Add('X',10);
        dict.Add('L',50);
        dict.Add('C',100);
        dict.Add('D',500);
        dict.Add('M',1000);
        
        var ans = 0;
        var index = 0;
        
        while(index < s.Length-1)
        {
            var c = s[index];
            var n = s[index+1];
            
            if((c == 'I' && (n == 'V' || n == 'X')) || 
               (c == 'X' && (n == 'L' || n == 'C')) || 
               (c == 'C' && (n == 'D' || n == 'M')))
            {
                ans += dict[n] - dict[c];
                index+=2;
            }else{
                ans += dict[c];
                index++;
            }   
        }
        
        if(index == s.Length-1) ans += dict[s[s.Length-1]];
        
        return ans;
    }
}