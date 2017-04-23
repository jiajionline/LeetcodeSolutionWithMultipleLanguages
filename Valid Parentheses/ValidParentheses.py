
class ValidParentheses(object):
    def isValid(self,s):
        if s is None or len(s) % 2 != 0:
            return False
        stack = []
        for c in s:
            if c == '(':
                stack.append(')')
            elif c == '[':
                stack.append(']')
            elif c == '{':
                stack.append('}')
            else:
                if len(stack) == 0 or stack.pop() != c:
                    return False
        return len(stack) == 0
        