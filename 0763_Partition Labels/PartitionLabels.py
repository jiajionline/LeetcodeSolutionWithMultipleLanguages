class Solution:
  def partitionLabels(self, S):
    last_index = {}
    for i, ch in enumerate(S):
      last_index[ch] = i
    start = end = 0
    ans = []
    for i, ch in enumerate(S):
      end = max(end, last_index[ch])
      if i == end:
        ans.append(end - start + 1)
        start = end + 1
    return ans