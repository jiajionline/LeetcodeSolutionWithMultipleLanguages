class MyCircularDeque {
    private int[] deque;
    private int size = 0, front = -1, rear = -1;

    public MyCircularDeque(int k) {
        deque = new int[k];
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        // hasn't initialized, first time to use
        if(front == -1) {
            front = deque.length-1;
            rear = deque.length-1;
        // reach the top
        }else if(front == 0){
            front = deque.length-1;
        }else{
            front--;
        }
        deque[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(rear == -1){
            front = 0; rear = 0;
        }else if(rear == deque.length-1){
            rear = 0;
        }else{
            rear++;
        }

        deque[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = front == deque.length-1 ? 0 : front+1;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = rear == 0 ? deque.length-1 : rear-1;
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == deque.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */