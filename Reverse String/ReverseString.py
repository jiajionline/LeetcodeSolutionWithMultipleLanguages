class ReverseString(object):
    def reverseString(self, s):
        if s is None or len(s) <=1:
            return s
        charArray = list(s)
        for i in range(len(charArray)/2):
            temp = charArray[len(charArray) - i -1]
            charArray[len(charArray) - i -1] = charArray[i]
            charArray[i] = temp
        return ''.join(charArray)