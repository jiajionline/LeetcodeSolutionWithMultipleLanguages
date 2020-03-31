class Solution:
  def romanToInt(self, s):
    dict = {'I' : 1, 'V': 5, 'X': 10, 'L' : 50, 'C' : 100, 'D': 500, 'M': 1000}
    ans = dict[s[0]]
    for c, p in zip(s[1:], s[0:-1]):
      ans += dict[c]
      if dict[c] > dict[p]: ans -= 2 * dict[p]
    return ans