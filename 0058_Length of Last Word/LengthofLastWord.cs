public class Solution {
   public int LengthOfLastWord(string s) {
       if(string.IsNullOrWhiteSpace(s)) return 0;
       var end = s.Length - 1;
       while(end >=0 && s[end]==' '){
           end--;
       }    

       var begin = end - 1;
       while(begin >=0 && s[begin]!=' '){
           begin--;
       }

       return end - begin;
   }
}
