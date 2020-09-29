class Solution:
  def wordBreak(self, s, wordDict):
    words = set(wordDict)
    mem = {}
    def wordBreak(s):
      if s in mem: return mem[s]
      ans = []
      if s in words: ans.append(s)
      for i in range(1, len(s)):
        r = s[i:]
        if r not in words: continue        
        ans += [w + " " + r for w in wordBreak(s[0:i])]
      mem[s] = ans
      return mem[s]
    return wordBreak(s)