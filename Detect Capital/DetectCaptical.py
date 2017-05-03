class DetectCaptical(object):
    def detectCapitalUse(self, word):
        if word is None or len(word) == 0:
            return False
        countOfCapital = 0
        countOfNonCapital = 0
        others = 0
        for c in word:
            if c >= 'A' and c <= 'Z':
                countOfCapital += 1
            elif c >= 'a' and c <= 'z':
                countOfNonCapital += 1
            else:
                others += 1
        
        if others > 0:
            return False
        if countOfCapital == len(word) or countOfNonCapital == len(word):
            return True
        if word[0] >= 'A' and word[0] <= 'Z' and countOfNonCapital + 1 == len(word):
            return True
        return False  