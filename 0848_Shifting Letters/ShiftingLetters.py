class Solution:
    def shiftingLetters(self, S, shifts):
        for i in range(len(shifts) - 1)[::-1]: 
            shifts[i] += shifts[i + 1]
        return "".join(chr((ord(c) - 97 + s) % 26 + ord('a')) for c, s in zip(S, shifts))