class MyLinkedList {
    class Node {
      public int val;
      public Node next;
      public Node(int val) { this.val = val; this.next = null; }
      public Node(int val, Node next) { this.val = val; this.next = next; }
    }
    
    private Node _head;
    private Node _tail;
    private int _size;
    
    public MyLinkedList() {
      this._head = this._tail = null;
      this._size = 0;
    }
    
    private Node getNode(int index) {
      Node node = new Node(0, this._head);
      while (index-- >= 0) {
        node = node.next;
      }
      return node;
    }
   
    public int get(int index) {
      if (index < 0 || index >= _size) return -1;
      return getNode(index).val;
    }
   
    public void addAtHead(int val) {
      this._head = new Node(val, this._head);
      if (this._size++ == 0)
        this._tail = this._head;    
    }
   
    public void addAtTail(int val) {
      Node node = new Node(val);
      if (this._size++ == 0)
        this._head = this._tail = node;
      else
        this._tail = this._tail.next = node;
    }
   
    public void addAtIndex(int index, int val) {
      if (index < 0 || index > this._size) return;
      if (index == 0)  { this.addAtHead(val); return; }
      if (index == _size) { this.addAtTail(val); return; }
      Node prev = this.getNode(index - 1);
      prev.next = new Node(val, prev.next);
      ++this._size;
    }
   
    public void deleteAtIndex(int index) {
      if (index < 0 || index >= this._size) return;
      Node prev = this.getNode(index - 1);
      prev.next = prev.next.next;
      if (index == 0) this._head = prev.next;
      if (index == this._size - 1) this._tail = prev;
      --this._size;
    }
  }