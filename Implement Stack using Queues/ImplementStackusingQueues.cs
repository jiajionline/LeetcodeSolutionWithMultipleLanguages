using System;
using System.Collections.Generic;

namespace LeetcodePracticeCsharpVersion
{
    class MyStack
    {
        private Queue<int> current = new Queue<int>();
        private Queue<int> backup = new Queue<int>();
        /** Initialize your data structure here. */
        public MyStack()
        {

        }

        /** Push element x onto stack. */
        public void Push(int x)
        {
            current.Enqueue(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int Pop()
        {
            Adjust();
            return current.Dequeue();
        }

        /** Get the top element. */
        public int Top()
        {
            Adjust();
            return current.Peek();
        }

        /** Returns whether the stack is empty. */
        public bool Empty()
        {
            return current.Count == 0 && backup.Count == 0;
        }

        private void Adjust()
        {
            if (Empty()) return;

            if (current.Count == 0)
            {
                var temp = current;
                current = backup;
                backup = temp;
            }

            while (current.Count > 1)
            {
                backup.Enqueue(current.Dequeue());
            }
            
        }
    }
}
