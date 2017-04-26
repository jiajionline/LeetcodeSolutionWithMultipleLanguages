class PlusOne(object):
    def plusOne(self, digits):
        tempList = list(digits[:])        
        i, carry = len(digits) - 1, 1
        while i >= 0 and carry > 0:
            v = digits[i]
            v += carry
            tempList[i] = v % 10
            carry = int(v / 10)
            i -= 1
        if carry == 0:
            return tempList
        else:
            tempList = list(reversed(tempList))
            tempList.append(carry)
            return list(reversed(tempList))            
            