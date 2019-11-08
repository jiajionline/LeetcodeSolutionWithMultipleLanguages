    public class Solution
    {
        public int[] AsteroidCollision(int[] asteroids)
        {
            var stack = new Stack<int>();
            foreach (var asteroid in asteroids)
            {
                if(stack.Count == 0 || asteroid > 0)
                {
                    stack.Push(asteroid);
                    continue;
                }
 
                while (true)
                {
                    if(stack.Peek() < 0)
                    {
                        stack.Push(asteroid);
                        break;
                    }
 
                    if(stack.Peek() == -asteroid)
                    {
                        stack.Pop();
                        break;
                    }
 
                    if(stack.Peek() > -asteroid)
                    {
                        break;
                    }
 
                    stack.Pop();
 
                    if(stack.Count == 0)
                    {
                        stack.Push(asteroid);
                        break;
                    }
                }
 
            }
 
            return stack.ToArray().Reverse().ToArray();
        }
    }
}
