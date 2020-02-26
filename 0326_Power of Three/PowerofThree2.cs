public class Solution {
   public bool IsPowerOfThree(int n) {
       return IsThreePower(n);
   }
  
   private bool IsThreePower(double n)
   {
       if(n == 1) return true;
       if(n < 3) return false;
       return IsThreePower(n/3);
   }
}