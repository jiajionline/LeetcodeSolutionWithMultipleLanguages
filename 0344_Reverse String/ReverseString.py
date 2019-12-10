class Solution:
    def reverseString(self, s):
        if s is None or len(s) <= 1:return
        left, right = 0, len(s) - 1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left, right = left + 1, right - 1
