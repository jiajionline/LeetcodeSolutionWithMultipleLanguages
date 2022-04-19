class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        while(p!=null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        
        p = head;
        while(p!=null) {
            if(p.random!=null) {
                p.next.random = p.random.next;
            }
             p = p.next.next;
        }
        
        p = head;
        Node newHead = p.next;
        Node p2 = newHead;
        
        while(p != null) {
            p.next = p2.next;
            p = p.next;
            if(p!=null) {
                p2.next = p.next;
                p2 = p2.next;
            }
        }
        
        return newHead;
    }
}