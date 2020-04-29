class Solution:
  def partitionLabels(self, S):
    ans = []
    start, end = 0, 0
    for i in range(len(S)):
      end = max(end, S.rfind(S[i]))
      if i == end:
        ans.append(end - start + 1)
        start = end + 1
    return ans