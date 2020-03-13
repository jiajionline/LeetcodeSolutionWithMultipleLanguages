public class Solution {
   public int[] PlusOne(int[] digits) {
       if(digits == null || digits.Length == 0) return new int[1]{1};
       bool carry = true;
       for(int i=digits.Length-1;i>=0;i--)
       {
           if(carry)
           {
               digits[i]++;
           }

           carry = digits[i] > 9;
           digits[i] %= 10;
       }

       if(carry){
           var ret = new int[digits.Length+1];
           ret[0] = 1;
           for(int i=0;i<digits.Length;i++){
               ret[i+1] = digits[i];
           }
           return ret;
       }

       return digits;
   }
}