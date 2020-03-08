public class LFUCache {

    private Dictionary<int, Node> nodeDict = new Dictionary<int, Node>();
    private Dictionary<int, DLList> countDict = new Dictionary<int, DLList>();
    private int capacity;
    private int min;
    private int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int Get(int key) {
        if(nodeDict.ContainsKey(key)) {
            var node = nodeDict[key];
            Update(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void Put(int key, int value) {
        if(capacity == 0) return;
        Node node;
        if(nodeDict.ContainsKey(key)) {
            node = nodeDict[key];
            node.value = value;
            Update(node);
        } else {
            node = new Node(key, value);
            nodeDict.Add(key, node);
            if(size == capacity) {
                DLList lastList = countDict[min];
                nodeDict.Remove(lastList.RemoveLast().key);
                size--;
            }
            size++;
            min = 1;

            DLList newList = null;
            if(countDict.ContainsKey(node.cnt)) {
                newList = countDict[node.cnt];
            } else {
                newList = new DLList();
            }

            newList.Add(node);
            if(countDict.ContainsKey(node.cnt)) {
                countDict[node.cnt] = newList;
            } else {
                countDict.Add(node.cnt, newList);
            }

        }
    }

    private void Update(Node node) {
        var oldList = countDict[node.cnt];
        oldList.Remove(node);
        if(node.cnt == min && oldList.size == 0) min++;
        node.cnt++;

        DLList newList = null;
        if(countDict.ContainsKey(node.cnt)) {
            newList = countDict[node.cnt];
        } else {
            newList = new DLList();
        }

        newList.Add(node);
        if(countDict.ContainsKey(node.cnt)) {
            countDict[node.cnt] = newList;
        } else {
            countDict.Add(node.cnt, newList);
        }
    }
}

public class Node {
    public Node prev;
    public Node next;
    public int cnt;
    public int key;
    public int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        cnt = 1;
    }
}

public class DLList {
    public Node head, tail;
    public int size;
    public DLList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void Add(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        size++;
    }

    public void Remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node RemoveLast() {
        if(size > 0) {
            Node node = tail.prev;
            Remove(node);
            return node;
        } else return null;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */