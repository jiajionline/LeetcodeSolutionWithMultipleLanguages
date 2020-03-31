public class Solution {
    public int RomanToInt(string s) {
        if(String.IsNullOrEmpty(s)) return 0;
        
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
        while(index < s.Length){
            if(index + 1 < s.Length){
                
                int currVal = dict[s[index]];
                int nextVal = dict[s[index+1]];
                
                if(currVal >= nextVal){
                    ans += currVal;
                }else{
                    ans += (nextVal - currVal);
                    index++;
                }
                
                index++;
                
            }else{
                ans += dict[s[index++]];
            }
        }
        
        return ans;
        
    }
}