public class Solution {
    public int[] AsteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.Length == 0) return new int[0];
        var stack = new Stack<int>();
        
        foreach(var asteroid in asteroids)
        {
            if(asteroid > 0 || stack.Count == 0 || stack.Peek() < 0){
                stack.Push(asteroid);
            }else{
                var push = true;
                while(stack.Count > 0)
                {
                    var s = stack.Peek();
                    if(s > 0){
                        if(s > -asteroid){
                            push = false;
                            break;
                        }else if(s == -asteroid){
                            stack.Pop();
                            push = false;
                            break;
                        }else{
                            stack.Pop();
                        }
                    }else{
                        break;
                    }
                }
                
                if(push) stack.Push(asteroid);
            }
        }
        
        var list = new LinkedList<int>();
        while(stack.Count > 0){
            list.AddFirst(stack.Pop());
        }
        return list.ToArray();
    }
}