class Solution {
    public int countPrimes(int n) {
      int ans = 0;
      boolean[] isPrime = new boolean[n + 1];
      Arrays.fill(isPrime, true);
      isPrime[0] = false;
      if (n > 0) isPrime[1] = false;
      for (int i = 2; i < n; ++i) {
        if (!isPrime[i]) continue;
        ++ans;
        for (int j = 2 * i; j < n; j += i)
          isPrime[j] = false;
      }
      return ans;
    }
  }