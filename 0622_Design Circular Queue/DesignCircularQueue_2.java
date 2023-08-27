class MyCircularQueue {

    private int[] queue;
    private int front = 0;
    private int rear = -1;
    private int count;

    public MyCircularQueue(int k) {
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(count == queue.length) return false;

        // first time to enqueue
        if(rear == -1) {
            front = 0;
            rear = 0;
        // reach the end
        }else if(rear == queue.length-1) {
            rear = 0;
        }else{
            rear++;
        }
        count++;
        queue[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(count == 0) return false;
        
        if(front == queue.length-1) {
            front = 0;
        }else{
            front++;
        }
        count--;
        return true;
    }
    
    public int Front() {
         return count == 0 ? -1 : queue[front];
    }
    
    public int Rear() {
        return count == 0 ? -1 : queue[rear];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == queue.length;
    }
}