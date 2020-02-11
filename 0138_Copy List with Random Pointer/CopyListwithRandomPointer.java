class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap();
        Node p = head;

        while (p != null) {
            Node cloneP = new Node(p.val);
            if (!map.containsKey(p)) {
                map.put(p, cloneP);
            }
            p = p.next;
        }

        p = head;

        while (p != null && p.next != null) {
            map.get(p).next = map.get(p.next);
            p = p.next;
        }

        p = head;

        while(p !=null){
            if(p.random!=null) map.get(p).random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }
}