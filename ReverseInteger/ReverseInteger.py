class ReverseInteger(object):
        
    def reverse(self, x):                
        isNegative = x < 0
        ret = 0
        x = abs(x)
        while x > 0:
            ret *= 10
            ret += x % 10
            x /= 10
        if ret > 1<<31:
            return 0
                         
        if isNegative:
            return 0 - ret
        else:
            return ret
        