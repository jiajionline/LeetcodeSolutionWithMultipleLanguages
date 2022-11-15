class Solution {
   public boolean isHappy(int n) {
       int slow = n;
       int fast = next(n);
       while (fast != 1 && slow != fast) {
           slow = next(slow);
           fast = next(next(fast));
       }
       return fast == 1;
   }
   
   private int next(int n) {
    int totalSum = 0;
    while (n > 0) {
        int d = n % 10;
        n = n / 10;
        totalSum += d * d;
    }
    return totalSum;
}
}