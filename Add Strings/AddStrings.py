class AddStrings(object):
    def addStrings(self,num1,num2):
        if num1 is None or len(num1) == 0:
            return num2
        if num2 is None or len(num2) == 0:
            return num1
        index1 = len(num1) - 1
        index2 = len(num2) - 1
        carry = 0
        ret = list()
        while index1>=0 or index2>=0 or carry>0:
            value = 0
            value += carry
            if(index1>=0):
                value += num1[index1] - '0'
                index1 -=1
            if(index2>=0):
                value += num2[index2] - '0'
                index2 -=1
            carry = value / 10
            value %= 10
            ret.append(value)
        ret.reverse()        
        return str(ret)