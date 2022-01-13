 class MyHashMap {
        private final ListNode[] nodes = new ListNode[10000];

        public void put(int key, int value) {
            int i = idx(key);
            if (nodes[i] == null)
                nodes[i] = new ListNode(-1, -1);
            ListNode prev = find(nodes[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key) {
            int i = idx(key);
            if (nodes[i] == null)
                return -1;
            ListNode node = find(nodes[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            int i = idx(key);
            if (nodes[i] == null) return;
            ListNode prev = find(nodes[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        private int idx(int key) { 
            return Integer.hashCode(key) % nodes.length;
        }

        private ListNode find(ListNode bucket, int key) {
            ListNode node = bucket;
            //it's empty in the bucket, only has a header
            if(node.next == null) return bucket;
            ListNode prev = bucket;
            node = node.next;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }