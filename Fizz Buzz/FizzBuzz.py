class FizzBuzz(object):
    def fizzBuzz(self, n):
        retList = list()
        for i in range(1,n+1):
            if i % 3 == 0 and i % 5 ==0:
                retList.append("FizzBuzz")
            elif i % 3 == 0:
                retList.append("Fizz")
            elif i % 5 == 0:
                retList.append("Buzz")
            else:
                retList.append(str(i))
        return retList    