public class Solution {
   public int AddDigits(int num) {
       if(num < 10) return num;
       while(true){
           var sum = 0;
           while(num > 0){
               sum += (num % 10);
               num /= 10;
           }

           if(sum < 10) return sum;
           num = sum;
       }

       return int.MaxValue;
   }
}
