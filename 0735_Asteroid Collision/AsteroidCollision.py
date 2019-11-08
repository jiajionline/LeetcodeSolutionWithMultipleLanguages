class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        stack = []
        for asteroid in asteroids:
            if asteroid > 0 or len(stack) == 0:
                stack.append(asteroid)
                continue
            while True:
                if stack[len(stack)-1] < 0:
                    stack.append(asteroid)
                    break

                if stack[len(stack)-1] > -asteroid:
                    break
                    
                if stack[len(stack)-1] == -asteroid:
                    stack.pop()
                    break          
                    
                stack.pop()
                
                if len(stack) == 0:
                    stack.append(asteroid)
                    break

        return stack
