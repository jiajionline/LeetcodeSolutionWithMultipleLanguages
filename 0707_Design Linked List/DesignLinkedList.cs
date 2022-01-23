public class MyLinkedList {
    private Node head;
    private Node tail;
    private int count;

    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.Next = tail;
        tail.Prev = head;
        count = 0;
    }
    
    private Node Grab(int index) {
        var p = head;
        while(index-- >= 0)
            p = p.Next;
        
        return p;
    }
    
    public int Get(int index) {
        if(index < 0 || index >= count) return -1;
        return Grab(index).Val;
    }
    
    public void AddAtHead(int val) {
        var p = head.Next;
        var node = new Node(val);
        node.Prev = head;
        head.Next = node;
        node.Next = p;
        p.Prev = node;
        count++;
    }
    
    public void AddAtTail(int val) {
        var p = tail.Prev;
        var node = new Node(val);
        p.Next = node;
        node.Prev = p;
        node.Next = tail;
        tail.Prev = node;
        count++;
    }
    
    public void AddAtIndex(int index, int val) {
        if(index < 0 || index > count) return;
        var p = Grab(index);
        var node = new Node(val);
        p.Prev.Next = node;
        node.Prev = p.Prev;
        node.Next = p;
        p.Prev = node;
        count++;
    }
    
    public void DeleteAtIndex(int index) {
        if(index < 0 || index >= count) return;
        var p = Grab(index);
        p.Prev.Next = p.Next;
        p.Next.Prev = p.Prev;
        count--;
    }
}

class Node
{
    public Node(int val) 
    {
        this.Val = val;
    }
    public Node Next;
    public Node Prev;
    public int Val;
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */