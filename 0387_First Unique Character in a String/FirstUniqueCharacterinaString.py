class Solution(object):
    def firstUniqChar(self, s):
        if s is None or len(s)==0:
            return -1
        if len(s) == 1:
            return 0
        letterToCount = [0] * 26
        for c in s:
            letterToCount[ord(c)-ord('a')]+=1
        for i in range(0,len(s)):
            if letterToCount[ord(s[i])-ord('a')] == 1:
                return i
        return -1
                
        
        