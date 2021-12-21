class LRUCache {
    private int _capacity;
    private Node _head = new Node();
    private Node _tail;
    private HashMap<Integer, Node> _cache;
    
    public LRUCache(int capacity) {
        _capacity = capacity;
        _cache = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(_cache.containsKey(key))
        {
            Node node = _cache.get(key);
            remove(node);
            setHead(node);
            return node.Value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(_cache.containsKey(key))
        {
            Node node = _cache.get(key);
            node.Value = value;
            remove(node);
            setHead(node);
        }else{
            if(_cache.size() == _capacity){
                Node last = _tail;
                _cache.remove(_tail.Key);
                remove(last);
            }
            Node node = new Node();
            node.Key = key;
            node.Value = value;
            _cache.put(key, node);
            setHead(node);
        }
    }
    
    private void remove(Node node) {
        if(node.Prev != null) {
            node.Prev.Next = node.Next;
        }
        
        if(node.Next != null) {
            node.Next.Prev = node.Prev;
        }else{
            node.Prev.Next = null;
            _tail = node.Prev;
        }
    }
    
    private void setHead(Node node)
    {
        if(_head.Next != null)
        {
            Node next = _head.Next;
            _head.Next = node;
            node.Prev = _head;
            node.Next = next;
            next.Prev = node;
        }else{
            _head.Next = node;
            node.Prev = _head;
            _tail = node;
        }
    }
}

class Node {
    public int Key;
    public int Value;
    public Node Prev;
    public Node Next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */