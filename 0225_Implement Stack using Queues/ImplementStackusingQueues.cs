public class MyStack
{
    private Queue<int> queue = new Queue<int>();
    /** Initialize your data structure here. */
    public MyStack()
    {
    }

    /** Push element x onto stack. */
    public void Push(int x)
    {
        var size = queue.Count;
        queue.Enqueue(x);
        while(size-- > 0){
            queue.Enqueue(queue.Dequeue());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int Pop()
    {
        return queue.Dequeue();
    }

    /** Get the top element. */
    public int Top()
    {
        return queue.Peek();
    }

    /** Returns whether the stack is empty. */
    public bool Empty()
    {
        return queue.Count == 0;
    }
}
