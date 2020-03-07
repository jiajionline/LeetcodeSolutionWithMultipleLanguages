public class Node {
    public int key;
    public int value;
    public Node pre;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    int capacity;
    Dictionary<int, Node> dict = new Dictionary<int, Node>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int Get(int key) {
        if(dict.ContainsKey(key)) {
            Node n = dict[key];
            Remove(n);
            SetHead(n);
            return n.value;
        }

        return -1;
    }

    private void Remove(Node n) {
        if(n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if(n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }

    }

    private void SetHead(Node n) {
        n.next = head;
        n.pre = null;

        if(head != null)
            head.pre = n;

        head = n;

        if(end == null)
            end = head;
    }

    public void Put(int key, int value) {
        if(dict.ContainsKey(key)) {
            Node old = dict[key];
            old.value = value;
            Remove(old);
            SetHead(old);
        } else {
            Node created = new Node(key, value);
            if(dict.Count() >= capacity) {
                dict.Remove(end.key);
                Remove(end);
                SetHead(created);

            } else {
                SetHead(created);
            }

            dict.Add(key, created);
        }
    }
}