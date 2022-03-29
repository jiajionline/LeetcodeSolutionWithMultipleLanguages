class LRUCache {
    private int _capacity;
    private DoubleLinkedList _linkedList;
    private Map<Integer,Node> _cache;

    public LRUCache(int capacity) {
        _capacity = capacity;
        _linkedList = new DoubleLinkedList();
        _cache = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
        if(_cache.containsKey(key)) {
            //need to refresh the node sequence
            Node node = _cache.get(key);
            remove(node);
            refresh(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(_cache.containsKey(key)) {
            Node node = _cache.get(key);
            node.value = value;
            remove(node);
            refresh(node);
        }else {
            if(_cache.size() >= _capacity) {
            	remove(_linkedList.tail.prev);
            }    
            
            Node newNode = new Node(key, value);
            refresh(newNode);
        }
    }
    
    private void remove(Node node) {
    	Node prev = node.prev;
    	Node next = node.next;
    	prev.next = next;
    	next.prev = prev;
    	_cache.remove(node.key);
    }
    
    private void refresh(Node node) {
        Node next = _linkedList.header.next;
        _linkedList.header.next = node;
        node.prev = _linkedList.header;
        node.next = next;
        next.prev = node;
        _cache.put(node.key, node);
    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int value;
    
    public Node(int k, int v) {
        key = k;
        value = v;
    }
    
    @Override
    public String toString() {
    	return String.valueOf(value);
    }
}

class DoubleLinkedList {
    Node header;
    Node tail;
    
    public DoubleLinkedList() {
        header = new Node(-1,-1);
        tail = new Node(-1,-1);
        header.next = tail;
        tail.prev = header;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */