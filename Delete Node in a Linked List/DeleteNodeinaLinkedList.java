
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
    }
}
