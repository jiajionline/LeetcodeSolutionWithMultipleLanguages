class Solution {
  public int countPrimes(int n) {
      if(n <= 1) return 0;
      int ans = 0;
      boolean[] isPrime = new boolean[n];
      Arrays.fill(isPrime, true);
      for (int i = 2; i < n; ++i) {
          if(isPrime[i]){
              ans++;
              for (int j = 2 * i; j < n; j += i)
                  isPrime[j] = false;    
          }
      }
      
      return ans;
  }
}