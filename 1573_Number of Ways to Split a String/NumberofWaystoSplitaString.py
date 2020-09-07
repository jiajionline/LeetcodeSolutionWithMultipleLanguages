class Solution:
  def numWays(self, s: str) -> int:
    n = len(s)
    countOfOne = s.count('1')
    if countOfOne % 3 != 0: return 0
    if countOfOne == 0: return ((n - 1) * (n - 2) // 2) % (10**9 + 7)
    countOfOne //= 3
    l, r, c = 0, 0, 0
    for i, ch in enumerate(s):
      if ch == '1': c += 1
      if c == countOfOne: l += 1
      elif c == countOfOne * 2: r += 1
      
    return (l * r) % (10**9 + 7)