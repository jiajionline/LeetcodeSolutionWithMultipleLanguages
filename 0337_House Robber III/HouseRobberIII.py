class Solution:
  def rob(self, root):
    def rob(root):
      if not root: return 0, 0, 0
      l, ll, lr = rob(root.left)
      r, rl, rr = rob(root.right)
      return max(root.val + ll + lr + rl + rr, l + r), l, r
    
    return rob(root)[0]