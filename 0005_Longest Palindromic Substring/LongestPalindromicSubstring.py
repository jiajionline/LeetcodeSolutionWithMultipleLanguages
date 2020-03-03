class Solution:
  def longestPalindrome(self, s: str) -> str:
    n = len(s)
    def getLen(l, r):
      while l >= 0 and r < n and s[l] == s[r]:
        l -= 1
        r += 1
      return r - l - 1
    
    start = 0
    length = 0    
    for i in range(n):      
      cur = max(getLen(i, i),
                getLen(i, i + 1))
      if cur <= length: continue
      length = cur
      start = i - (cur - 1) // 2
    return s[start : start + length]