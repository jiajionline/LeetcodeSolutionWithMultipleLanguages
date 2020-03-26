class Solution:
  def countPrimes(self, n):
    if n < 3: return 0
    isPrime = [True] * (n + 1)
    isPrime[0] = False
    isPrime[1] = False
    ans = 0
    for i in range(2, n):
      if not isPrime[i]: continue
      ans += 1
      for j in range(2 * i, n, i):
        isPrime[j] = False
    return ans