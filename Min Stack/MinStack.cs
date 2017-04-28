using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    public class MinStack
    {
        Stack<int> stack = new Stack<int>();
        Stack<int> minStack = new Stack<int>();
        /** initialize your data structure here. */
        public MinStack()
        {

        }

        public void Push(int x)
        {
            if(stack.Count == 0 || minStack.Peek() >= x)
            {
                minStack.Push(x);
            }
            
            stack.Push(x);
        }

        public void Pop()
        {
            if (stack.Count == 0) return;
            var v = stack.Pop();
            if(minStack.Peek() == v)
            {
                minStack.Pop();
            }
        }

        public int Top()
        {
            return stack.Peek();
        }

        public int GetMin()
        {
            return minStack.Peek();
        }
    }
}
