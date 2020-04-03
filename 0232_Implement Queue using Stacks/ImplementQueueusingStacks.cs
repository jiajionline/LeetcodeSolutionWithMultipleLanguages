    class MyQueue
    {
        private Stack<int> enqueueStack = new Stack<int>();
        private Stack<int> dequeueStack = new Stack<int>();
        /** Push element x to the back of queue. */
        public void Push(int x)
        {
            enqueueStack.Push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int Pop()
        {
            this.Adjust();
            return dequeueStack.Pop();
        }

        /** Get the front element. */
        public int Peek()
        {
            Adjust();
            return dequeueStack.Peek();
        }

        /** Returns whether the queue is empty. */
        public bool Empty()
        {
            return enqueueStack.Count == 0 && dequeueStack.Count == 0;
        }

        private void Adjust()
        {
            if(dequeueStack.Count == 0)
            {
                while (enqueueStack.Count > 0)
                {
                    dequeueStack.Push(this.enqueueStack.Pop());
                }
            }            
        }
    }
}
