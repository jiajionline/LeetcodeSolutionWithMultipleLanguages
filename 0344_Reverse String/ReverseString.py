class Solution:
    def reverseString(self, s):
        if s is None or len(s) <= 1:return
        start, end = 0, len(s) - 1
        while start < end:
            s[start], s[end] = s[end], s[start]
            start, end = start + 1, end - 1
