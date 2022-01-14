public class Solution {
   private int lo;
   private int max;

   public string LongestPalindrome(string s) {
       if(string.IsNullOrEmpty(s)) return "";
       if(s.Length == 1) return s;

       for(int i=0;i<s.Length-1;i++){
           LengthOfPalindrome(s, i, i);
           LengthOfPalindrome(s, i, i+1);           
       }

       return s.Substring(lo,max);
   }

   private void LengthOfPalindrome(string s, int i, int j)
   {
       while(i>=0 && j<s.Length && s[i] == s[j])
       {           
           i--;
           j++;           
       }

       if(j-i-1>max)
       {
           max = j-i-1;
           lo = i+1;
       }
   }
}
