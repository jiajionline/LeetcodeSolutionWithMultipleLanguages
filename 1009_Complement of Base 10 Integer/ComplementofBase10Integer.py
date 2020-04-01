class Solution(object):
    def bitwiseComplement(self, N):
        ans = 1
        while N > ans:
            ans <<=1
            ans |= 1
        return ans ^ N
        