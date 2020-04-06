public class Solution {
   public bool RepeatedSubstringPattern(string s) {
       if(string.IsNullOrEmpty(s)) return false;
       var l = s.Length;
       if(l == 1) return false;
       for(int i=1;i<=l/2;i++)
       {
           if(l % i == 0){
               int subCount = (l / i);
               var subStr = s.Substring(0, l/subCount);
               var sb = new StringBuilder();
              
               for(int j=1;j<=subCount;j++){
                   sb.Append(subStr);
               }

               if(string.Equals(sb.ToString(), s)){
                   return true;
               }
           }
       }    
       return false; 
   }
}
