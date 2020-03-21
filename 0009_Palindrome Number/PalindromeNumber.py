class Solution(object):
    def isPalindrome(self, x):
        if x == (-sys.maxsize - 1):
            return False
        y = abs(x)
        value = 0
        while y > 0:
            value *= 10
            value += y % 10
            y /= 10
        if value > sys.maxsize:
            return False
        return value == x ? True:False