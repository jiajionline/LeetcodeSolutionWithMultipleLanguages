class ValidAnagram(object):
    def isAnagram(self, s, t):
        if len(s) != len(t):
            return False;
        dictionary = dict()
        for c in s:
            if c in dictionary:
                dictionary[c] += 1
            else:
                dictionary[c] = 1
        for c in t:
            if c in dictionary:
                dictionary[c] -= 1
            else:
                return False
        for c in dictionary.values():
            if c != 0:
                return False
        return True
        